package com.enigma.unit_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TodoRepositoryImpl implements TodoRepository{
    private final List<Todo> todos;

    public TodoRepositoryImpl() {
        this.todos = new ArrayList<>();
    }

    @Override
    public Todo save(Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        todos.add(todo);
        return todo;
    }

    @Override
    public Optional<Todo> findById(String id) {
        return todos.stream().filter(todo -> todo.getId().equals(id)).findFirst();
    }

    @Override
    public List<Todo> findAll() {
        return todos;
    }

    @Override
    public void delete(Todo todo) {
        todos.remove(todo);
    }
}
