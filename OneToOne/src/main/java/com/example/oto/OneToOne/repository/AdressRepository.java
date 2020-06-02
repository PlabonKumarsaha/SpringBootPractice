package com.example.oto.OneToOne.repository;

import com.example.oto.OneToOne.Model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

public interface AdressRepository extends JpaRepository<Adress,Long> {

}
