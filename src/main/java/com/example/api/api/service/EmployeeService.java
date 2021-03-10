package com.example.api.api.service;

import com.example.api.api.model.Employee;

import java.util.List;

public interface EmployeeService extends iService<Employee> {

    List<Employee> findAll(int page, int size);
}
