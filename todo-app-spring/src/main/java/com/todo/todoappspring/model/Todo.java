// src/main/java/com/todo/todoappspring/model/Todo.java

package com.todo.todoappspring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import lombok.Data; // De Lombok para getters, setters, etc.

@Data // Genera Getters, Setters, toString, equals, hashCode
@Document(collection = "tasks") // Especifica el nombre de la colección en MongoDB
public class Todo {
    
    // Este campo será el ObjectId de MongoDB
    @Id
    private String id;
    
    @NotBlank(message = "El título es obligatorio")
    private String title;
    
    private String description;
    
    private boolean completed = false;
    
    // Spring Data MongoDB lo gestiona automáticamente, pero lo dejamos
    // private Date createdAt = new Date(); 
}
