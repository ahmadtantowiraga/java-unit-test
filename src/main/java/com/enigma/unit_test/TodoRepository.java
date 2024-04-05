package com.enigma.unit_test;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo save(Todo todo);
    Optional<Todo> findById(String id);
    List<Todo> findAll();
    void delete(Todo todo);
}
