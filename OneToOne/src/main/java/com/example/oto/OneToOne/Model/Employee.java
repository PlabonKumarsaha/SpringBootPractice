package com.example.oto.OneToOne.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
/*
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)*/
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "empID",
            joinColumns = {@JoinColumn(name = "Empid")},
            inverseJoinColumns = {@JoinColumn(name = "AdrressId")}
    )
    private List<Adress>adresses;






 /*   @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "AfressId",referencedColumnName = "id")
    private Adress adress;
*/



}
