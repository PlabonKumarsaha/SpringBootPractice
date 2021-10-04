package com.example.OneToMany.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int uid;

    String name;
    String address;

    //user is the variable that did the manyto one rel
    @OneToMany(mappedBy = "user")
    List<Cart>carts;
}
