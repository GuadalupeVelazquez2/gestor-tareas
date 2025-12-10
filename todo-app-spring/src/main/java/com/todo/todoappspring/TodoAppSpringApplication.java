// src/main/java/com/todo/todo_app_spring/TodoAppSpringApplication.java

package com.todo.todoappspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration; // 👈 Importar
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration; // 👈 Importar

@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class, // Excluye configuración SQL DataSource
    HibernateJpaAutoConfiguration.class // Excluye configuración JPA/Hibernate
})
public class TodoAppSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppSpringApplication.class, args);
    }
}
