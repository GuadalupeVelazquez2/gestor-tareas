

package com.todo.todoappspring.controller;

import com.todo.todoappspring.model.Todo;
import com.todo.todoappspring.service.TodoService;
import jakarta.validation.Valid; // Para usar las anotaciones de validación (NotBlank)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:4200") // Permite al frontend de Angular acceder
public class TodoController {

    @Autowired
    private TodoService todoService;

    // 1. GET - Obtener todas las tareas
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }

    // 2. GET/:id - Obtener una tarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable String id) {
        return todoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. POST - Crear una nueva tarea
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        // @Valid activa la validación definida en la entidad (ej. @NotBlank)
        return todoService.save(todo);
    }

    // 4. PUT/:id - Actualizar una tarea existente
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String id, @Valid @RequestBody Todo todoDetails) {
        try {
            Todo updatedTodo = todoService.update(id, todoDetails);
            return ResponseEntity.ok(updatedTodo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. DELETE/:id - Eliminar una tarea
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No Content
    public void deleteTodo(@PathVariable String id) {
        todoService.deleteById(id);
    }
}