// server.js

// 1. Importar dependencias
require('dotenv').config(); // Carga las variables de entorno desde .env
const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors'); // Middleware para permitir peticiones desde el frontend de Angular

// 2. Importar Rutas
const todoRoutes = require('./src/routes/todoRoutes');

// 3. Inicializar la aplicación y la configuración
const app = express();
const PORT = process.env.PORT || 3000;
const MONGODB_URI = process.env.MONGODB_URI;

// 4. Configuración de Middlewares
// Permite que Express lea JSON en el cuerpo de las peticiones
app.use(express.json()); 

// Configuración de CORS
// Permite peticiones de cualquier origen. En producción, se debería restringir.
app.use(cors()); 

// 5. Conexión a la Base de Datos (MongoDB)
mongoose.connect(MONGODB_URI)
  .then(() => {
    console.log('Conectado exitosamente a MongoDB');
  })
  .catch(err => {
    console.error('Error de conexión a la base de datos:', err.message);
    // Termina el proceso si la conexión a la base de datos falla
    process.exit(1); 
  });

// 6. Definición de Rutas
// Ruta principal de prueba
app.get('/', (req, res) => {
  res.status(200).send('API de Gestor de Tareas Node.js/Express en funcionamiento. Accede a /api/todos para los endpoints CRUD.');
});

// Asigna las rutas de tareas con el prefijo /api/todos
app.use('/api/todos', todoRoutes); 

// 7. Manejo de Errores para rutas no encontradas (404)
app.use((req, res, next) => {
  res.status(404).json({ message: 'Ruta no encontrada' });
});

// 8. Iniciar el Servidor
app.listen(PORT, () => {
  console.log(`Servidor Node.js escuchando en: http://localhost:${PORT}`);
});