// src/routes/todoRoutes.js
const express = require('express');
const router = express.Router();
const todoController = require('../controllers/todoController');

// Definición de Endpoints CRUD

// GET /api/todos - Obtener todas las tareas
// POST /api/todos - Crear una nueva tarea
router.route('/')
  .get(todoController.getAllTodos)
  .post(todoController.createTodo);

// GET /api/todos/:id - Obtener tarea por ID
// PUT /api/todos/:id - Actualizar tarea por ID
// DELETE /api/todos/:id - Eliminar tarea por ID
router.route('/:id')
  .get(todoController.getTodoById)
  .put(todoController.updateTodo)
  .delete(todoController.deleteTodo);

module.exports = router;