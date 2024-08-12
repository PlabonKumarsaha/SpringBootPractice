package com.influxdb.influx.db_test;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/influx")
public class InfluxRestController {

    @Value("${INFLUXDB.BUCKET}")
    private String bucket;
    @Value("${INFLUXDB.ORG}")
    private String org;

    @Value("${INFLUXDB.TOKEN}")
    private String influxToken;

    @Value("${INFLUXDB.HOST.URL}")
    private String hostUrl;

    InfluxDBClient initiateDbClient() {
        final char[] authToken = influxToken.toCharArray();
        try {
            InfluxDBClient influxDBClient = InfluxDBClientFactory.create(hostUrl, authToken, bucket);
            return influxDBClient;
        } catch (Exception e) {
            System.err.println("An error occurred while connecting to InfluxDB!");
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping
    public String saveTestData( @RequestBody InfluxDbPostRequestDto dto
    ) throws InterruptedException {
        InfluxDBClient client = initiateDbClient();

        Point[] points = new Point[] {
                Point.measurement("census")
                        .addTag("location", dto.getLocation())
                        .addField("bees", dto.getNoOfBees())
                        .addField("cats", dto.getNoOfCats())
//                Point.measurement("census")
//                        .addTag("location", "Portland")
//                        .addField("ants", 30),
//                Point.measurement("census")
//                        .addTag("location", "Klamath")
//                        .addField("bees", 28),
//                Point.measurement("census")
//                        .addTag("location", "Portland")
//                        .addField("ants", 32),
//                Point.measurement("census")
//                        .addTag("location", "Klamath")
//                        .addField("bees", 29),
//                Point.measurement("census")
//                        .addTag("location", "Portland")
//                        .addField("ants", 40)
        };

        WriteApiBlocking writeApi = client.getWriteApiBlocking();
        for (Point point : points) {
            writeApi.writePoint(bucket, org, point);

            Thread.sleep(1000); // separate points by 1 second
        }

        System.out.println("Complete. Return to the InfluxDB UI.");

    return "OK";
    }

    @GetMapping
    public String getSavedDataTestData(
    ) throws InterruptedException {
        QueryApi queryApi = initiateDbClient().getQueryApi();

        String query = "from(bucket: \"test\")" +
                " |> range(start: -10m)";

        for (FluxTable table : queryApi.query(query, org)) {
            List<FluxRecord> records = table.getRecords();
            for (FluxRecord record : records) {
                String field = record.getField();
                Object value = record.getValue();
                Instant time = record.getTime();
                InfluxDbResponseDto dto = new InfluxDbResponseDto();

                System.out.printf("| %-5s | %-5s | %-30s |%n", field, value, time);
            }
        }
        return "OK";
    }

}
