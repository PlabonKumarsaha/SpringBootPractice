package com.example.oto.OneToOne;

import com.example.oto.OneToOne.Model.Adress;
import com.example.oto.OneToOne.Model.Employee;
import com.example.oto.OneToOne.repository.AdressRepository;
import com.example.oto.OneToOne.repository.EmployeeRepository;
import org.apache.tomcat.jni.Address;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.Arrays;

@Configuration
public class DbUnit {

    private final EmployeeRepository employeeRepository;
    private final AdressRepository adressRepository;


    public DbUnit(EmployeeRepository employeeRepository, AdressRepository adressRepository) {
        this.employeeRepository = employeeRepository;
        this.adressRepository = adressRepository;
    }
    @PostConstruct
    public void init(){

        Employee employee = new Employee();
        employee.setName("PKS");


        Adress adress = new Adress();
        adress.setCity("Dhaka");
        adress.setCountry("BD");
        adress.setEmployees(Arrays.asList(employee));
        employee.setAdresses(Arrays.asList(adress));

        employee = employeeRepository.save(employee);

        adress = adressRepository.save(adress);
        //adress.setEmployees(Arrays.asList(employee));



       /* Adress adress1 = new Adress();
        adress1.setCity("N.gonj");
        adress1.setCountry("BD");
        adress1.setEmployees(Arrays.asList(employee));
        adress1 = adressRepository.save(adress1);
        employee.setAdresses(Arrays.asList(adress1));




        employee.setAdresses(Arrays.asList(adress));
*/

        System.out.println("Emp id : "+employee.getId());
        System.out.println("adress  id : "+adress.getId());

    /*

      Employee employee = new Employee();
        employee.setName("pks");

        Adress adress = new Adress();
        adress.setCity("N.gonj");
        adress.setCountry("BD");
        employee.setAdresses(Arrays.asList(adress));
        employee = employeeRepository.save(employee);


        adress.setEmployee(employee);
        adressRepository.save(adress);
        System.out.println("Emp id : "+employee.getId());
        System.out.println("adress  id : "+adress.getId());

        //second isntance

        Employee employee1 = new Employee();
        employee1.setName("pks2");

        Adress adress1 = new Adress();
        adress1.setCity("N.gonj1");
        adress1.setCountry("BD1");
        employee1.setAdresses(Arrays.asList(adress1));
        employee1 = employeeRepository.save(employee1);

        adress1.setEmployee(employee1);
        adressRepository.save(adress1);
        System.out.println("Emp id : "+employee1.getId());
        System.out.println("adress  id : "+adress1.getId());*/



        //employee.setName()

        /*Adress address = new Adress();
        address.setCity("dhaka");
        address.setCountry("bd");
//      address = addressRepository.save(address);
        Employee employee = new Employee();
        employee.setName("pks");
        employee.setAdresses(Arrays.asList(address));
        employee = employeeRepository.save(employee);
        address.setEmployee(employee);
        adressRepository.save(address);
        System.out.println("Employee ID =  " + employee.getId());
        System.out.println("ADDRESS ID =  " + address.getId());*/
    }
}
