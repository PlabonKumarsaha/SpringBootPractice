package com.influxdb.influx.db_test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfluxDbPostRequestDto {
    String location;
    Integer noOfBees;
    Integer noOfCats;
}
