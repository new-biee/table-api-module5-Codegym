package com.example.api.api.service.impl;

import com.example.api.api.model.Employee;
import com.example.api.api.repository.ApiRepository;
import com.example.api.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ApiRepository apiRepository;

    @Override
    public List<Employee> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Employee> students = apiRepository.findAll(pageRequest);
        return students.getContent();
    }

    @Override
    public List<Employee> findAll() {
        return apiRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return apiRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return apiRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        apiRepository.deleteById(id);
    }
}
