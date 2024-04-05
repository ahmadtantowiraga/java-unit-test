package com.enigma.unit_test;

import java.util.List;

public interface TodoService {
    Todo create(Todo todo);

    Todo getById(String id);

    List<Todo> getAll();
    void deleteById(String id);
}
