package com.example.api.api.repository;
import com.example.api.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Employee, Long>{
    
}
