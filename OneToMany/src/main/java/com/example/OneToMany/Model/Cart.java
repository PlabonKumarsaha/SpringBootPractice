package com.example.OneToMany.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int cid;

    double totalPrice;
    String address;

    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "product_fk",referencedColumnName = "id", nullable = false)
    List<Product>products;

    @ManyToOne
    User user;

}
