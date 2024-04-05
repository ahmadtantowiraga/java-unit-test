package com.enigma.unit_test;

import java.util.List;

public class TodoServiceImpl implements TodoService{
    private final  TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo getById(String id) {
        return todoRepository.findById(id).orElseThrow(()->new RuntimeException("todo not found"));
    }

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Todo todo =getById(id);
        todoRepository.delete(todo);
    }
}
