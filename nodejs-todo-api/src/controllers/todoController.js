// src/controllers/todoController.js
const Todo = require('../models/todoModel');

// Obtener todas las tareas
exports.getAllTodos = async (req, res) => {
  try {
    const todos = await Todo.find();
    res.status(200).json(todos);
  } catch (error) {
    res.status(500).json({ message: 'Error al obtener tareas', error: error.message });
  }
};

// Crear una nueva tarea (POST)
exports.createTodo = async (req, res) => {
  try {
    const newTodo = new Todo(req.body);
    const todo = await newTodo.save();
    res.status(201).json(todo);
  } catch (error) {
    res.status(400).json({ message: 'Error al crear tarea', error: error.message });
  }
};

// Obtener una tarea por ID (GET :id)
exports.getTodoById = async (req, res) => {
  try {
    const todo = await Todo.findById(req.params.id);
    if (!todo) {
      return res.status(404).json({ message: 'Tarea no encontrada' });
    }
    res.status(200).json(todo);
  } catch (error) {
    res.status(500).json({ message: 'Error al buscar tarea', error: error.message });
  }
};

// Actualizar una tarea (PUT :id)
exports.updateTodo = async (req, res) => {
  try {
    const todo = await Todo.findByIdAndUpdate(req.params.id, req.body, { new: true, runValidators: true });
    if (!todo) {
      return res.status(404).json({ message: 'Tarea no encontrada para actualizar' });
    }
    res.status(200).json(todo);
  } catch (error) {
    res.status(400).json({ message: 'Error al actualizar tarea', error: error.message });
  }
};

// Eliminar una tarea (DELETE :id)
exports.deleteTodo = async (req, res) => {
  try {
    const todo = await Todo.findByIdAndDelete(req.params.id);
    if (!todo) {
      return res.status(404).json({ message: 'Tarea no encontrada para eliminar' });
    }
    res.status(204).send(); // 204 No Content
  } catch (error) {
    res.status(500).json({ message: 'Error al eliminar tarea', error: error.message });
  }
};