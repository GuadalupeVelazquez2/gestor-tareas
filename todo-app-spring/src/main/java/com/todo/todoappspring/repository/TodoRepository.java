package com.todo.todoappspring.repository;

import com.todo.todoappspring.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    // Aquí puedes añadir métodos de búsqueda personalizados si son necesarios (ej. findByTitle)
}