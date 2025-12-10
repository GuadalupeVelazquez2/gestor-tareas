

package com.todo.todoappspring.service;

import com.todo.todoappspring.model.Todo;
import com.todo.todoappspring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // CREATE
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    // READ ALL
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    // READ BY ID
    public Optional<Todo> findById(String id) {
        return todoRepository.findById(id);
    }

    // UPDATE
    public Todo update(String id, Todo todoDetails) {
        // Usa findById para asegurar que el objeto existe antes de actualizar
        return todoRepository.findById(id).map(todo -> {
            todo.setTitle(todoDetails.getTitle());
            todo.setDescription(todoDetails.getDescription());
            todo.setCompleted(todoDetails.isCompleted());
            return todoRepository.save(todo);
        }).orElseThrow(() -> new RuntimeException("Tarea no encontrada con id: " + id)); 
    }

    // DELETE
    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }
}
