package com.example.api.api.controller;

import com.example.api.api.model.Employee;
import com.example.api.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/employees")

public class AppController {

    @Autowired
    private EmployeeService employeeService;

    //Find All
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ResponseEntity<List<Employee>> responseEntity = new ResponseEntity<>(employees, HttpStatus.OK);
        return responseEntity;
    }

    //Create
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Optional<Employee> eOptional = employeeService.findById(id);
        if (eOptional.isPresent()) {
            employeeService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Update
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.findById(id);
        return employeeService.save(employee);
    }

    //Find One
    @GetMapping("/{id}")
    public ResponseEntity<Employee> employeeDetail(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
