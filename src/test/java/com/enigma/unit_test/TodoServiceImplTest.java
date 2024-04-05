package com.enigma.unit_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TodoServiceImplTest {
    @Test
    void ShouldReturnTodoWhenCreate(){
        //Given
        Todo todo=new Todo(null, "turu");

        //Stubbing
        TodoRepository todoRepository= Mockito.mock(TodoRepository.class);
        //Stubbing konfigurasi
        Mockito.when(todoRepository.save(todo)).thenReturn(new Todo(UUID.randomUUID().toString(), "Turu"));

        TodoService todoService=new TodoServiceImpl(todoRepository);

        //When
        Todo result=todoService.create(todo);

        //Then

        Assertions.assertNotNull(result);
    }
    @Test
    void ShouldReturnTodoWhenGetById(){
        //Given
        String id="Exmple-id";
        //Stubbing
        TodoRepository todoRepository= Mockito.mock(TodoRepository.class);
        //Stubbing konfigurasi
        Mockito.when(todoRepository.findById(id)).thenReturn(Optional.of(new Todo(id, "Turu")));

        TodoService todoService=new TodoServiceImpl(todoRepository);

        //When
        Todo todo=todoService.getById(id);

        //Then
        System.out.println(todo.getId());
        System.out.println(todo.getTask());
        Assertions.assertNotNull(todo);
        Assertions.assertEquals(id, todo.getId());
    }
    //Negatif
    @Test
    void ShouldThrowRunTimeExceptionWhenGetById(){
        //Given
        String id="Exmple-id";
        //Stubbing
        TodoRepository todoRepository= Mockito.mock(TodoRepository.class);
        //Stubbing konfigurasi
        Mockito.when(todoRepository.findById(id)).thenThrow(new RuntimeException("yayaya"));

        TodoService todoService=new TodoServiceImpl(todoRepository);


        //Then
        Assertions.assertThrows(RuntimeException.class, ()->{
            //when
            todoService.getById(id);

        });
    }

    @Test
    void shouldReturnTodoWhenGetAll(){
        //Given

        //Stubbing
        TodoRepository todoRepository=Mockito.mock(TodoRepository.class);

        //Stubbing Konfigurasi
        Mockito.when(todoRepository.findAll()).thenReturn(List.of(new Todo(null,"Ngising"), new Todo(null, "Madang")));
        TodoService todoService=new TodoServiceImpl(todoRepository);
        //When
        List<Todo> todos=todoService.getAll();

        Assertions.assertNotNull(todos);
        Assertions.assertEquals(2, todos.size());
    }

    @Test
    void shouldDeleteByIdSuccessfully(){
        //Given
        String id="test-1";

        //Stubing
        TodoRepository todoRepository=Mockito.mock(TodoRepository.class);

        //Stubbing Config 2x
        Optional<Todo> todoOptional=Optional.of(new Todo(id, "Turu"));
        Mockito.when(todoRepository.findById(id)).thenReturn(todoOptional);
        Mockito.doNothing().when(todoRepository).delete(todoOptional.get());

        TodoService todoService=new TodoServiceImpl(todoRepository);

        //when
        todoService.deleteById(id);

        //yhen
        Mockito.verify(todoRepository, Mockito.times(1)).delete(todoOptional.get());
    }
}
