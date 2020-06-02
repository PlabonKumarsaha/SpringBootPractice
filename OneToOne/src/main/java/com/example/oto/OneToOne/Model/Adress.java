package com.example.oto.OneToOne.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String country;
    @ManyToMany(mappedBy = "adresses", fetch = FetchType.EAGER)

    List<Employee>employees;



    /*@ManyToOne
    @JoinColumn(name = "EmpId")
    private  Employee employee;*/






}
