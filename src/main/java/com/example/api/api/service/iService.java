package com.example.api.api.service;

import com.example.api.api.model.Employee;

import java.util.List;
import java.util.Optional;

public interface iService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);

}
