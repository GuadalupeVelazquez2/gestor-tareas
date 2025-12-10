# Gestor de Tareas Full Stack (Monorepo)

Este repositorio contiene la implementación de un Gestor de Tareas usando una arquitectura Dual-Stack.

##  Estructura del Proyecto

* **`frontend-angular/`**: Aplicación Cliente (Angular 17+ y Angular Material).
* **`backend-spring/`**: API RESTful implementada en Java con Spring Boot (Puerto 8081).
* **`backend-node/`**: API RESTful implementada en JavaScript con Node.js/Express (Puerto 3000).

## Requisitos Previos

* Java JDK 17+
* Node.js LTS
* Angular CLI
* MongoDB (Instancia local o en la nube)

## Instrucciones de Ejecución

Para iniciar el sistema completo, debe ejecutar cada componente en una terminal separada:

### 1. Iniciar MongoDB

Asegúrese de que su instancia de MongoDB esté corriendo en el puerto 27017.

### 2. Iniciar el Backend (Spring Boot)

```bash
cd backend-spring
# Usar el comando de tu IDE (VS Code o IntelliJ) para correr la aplicación
# La API estará disponible en http://localhost:8081/api/todos
3. Iniciar el Frontend (Angular)
Bash

cd frontend-angular
npm install
ng serve --open
# La interfaz estará disponible en http://localhost:4200
