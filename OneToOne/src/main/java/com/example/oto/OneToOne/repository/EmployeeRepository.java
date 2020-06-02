package com.example.oto.OneToOne.repository;

import com.example.oto.OneToOne.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee,Long>{



}
