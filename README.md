# 🛒 Carrito de Compras - Arquitectura en Capas

## 📌 Descripción

Este proyecto implementa un sistema de carrito de compras utilizando **arquitectura en capas** con Spring Boot.

El sistema permite gestionar productos mediante un CRUD completo y simular un proceso de compra (checkout) con una interfaz web.

---

## 🧱 Arquitectura

El proyecto está dividido en las siguientes capas:

* Model → Define los datos (Product)
* Repository → Manejo de almacenamiento en memoria
* Service → Lógica del negocio
* Controller → Manejo de peticiones HTTP
* Frontend → Interfaz web (HTML, CSS, JS)

---

## ⚙️ Tecnologías utilizadas

* Java
* Spring Boot
* HTML
* CSS
* JavaScript
* API REST

---

## 🚀 Funcionalidades

* Agregar productos
* Listar productos
* Editar productos
* Eliminar productos
* Vaciar carrito
* Calcular total con descuento
* Checkout (simulación de pago)
* Registro de datos del cliente
* Búsqueda en tiempo real (frontend)

---

## 🌐 Endpoints principales

* GET /cart → Obtener productos
* POST /cart → Agregar producto
* PUT /cart/{id} → Actualizar producto
* DELETE /cart/{id} → Eliminar producto
* DELETE /cart/clear → Vaciar carrito
* GET /cart/total → Calcular total
* POST /cart/checkout → Simular pago

---

## ▶️ Cómo ejecutar

### 1. Abrir el proyecto en Visual Studio Code

Instalar extensiones:

* Java Extension Pack
* Spring Boot Extension Pack

---

### 2. Ejecutar el proyecto

Desde la clase principal:

```
CapasCartApplication.java
```

Presionar botón ▶️ Run

---

### 3. Acceder a la aplicación

Abrir navegador:

```
http://localhost:8080
```

---

## 🖥️ Interfaz

La aplicación incluye una interfaz web que permite:

* Interacción con el carrito
* Gestión de productos
* Búsqueda
* Checkout con datos del cliente

---

## 💾 Persistencia

Los datos se almacenan en memoria utilizando un `Map`, por lo que se pierden al reiniciar la aplicación.

---

## 🎯 Propósito del proyecto

Demostrar el uso de arquitectura en capas y compararlo con el enfoque de código spaghetti.

---

## 📊 Conclusión

La arquitectura en capas permite desarrollar sistemas más estructurados y profesionales, facilitando su mantenimiento y evolución.

---
