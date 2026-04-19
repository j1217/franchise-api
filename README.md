# 🚀 Franchise API

Prueba técnica backend desarrollada en Spring Boot para la administración de franquicias, sucursales y productos, aplicando buenas prácticas de desarrollo, arquitectura por capas y despliegue con Docker.

---

# 📌 Descripción General

El sistema permite gestionar:

- Franquicias
- Sucursales asociadas a cada franquicia
- Productos por sucursal
- Stock por producto
- Reporte del producto con mayor stock por sucursal

La solución fue diseñada priorizando:

- Código limpio
- Escalabilidad
- Mantenibilidad
- Buenas prácticas REST
- Separación de responsabilidades

---

# 🛠️ Tecnologías Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL 8
- Maven
- Swagger / OpenAPI
- Docker
- Git / GitHub

---

# 🏗️ Arquitectura del Proyecto

src/main/java/com/accenture/franchiseapi/

controller  
service  
repository  
entity  
dto  

## Responsabilidades

- controller: Exposición de endpoints REST
- service: Lógica de negocio
- repository: Acceso a base de datos
- entity: Modelado JPA
- dto: Respuestas personalizadas

---

# ⚙️ Configuración por Ambientes

Se implementaron perfiles Spring Boot:

- dev: Ejecución local
- docker: Ejecución en contenedores

Archivos:

application.properties  
application-dev.properties  
application-docker.properties

---

# ▶️ Ejecución Local

## Requisitos Previos

- Java 21
- Maven
- MySQL 8

## Crear Base de Datos

CREATE DATABASE franchise_db;

## Ejecutar Proyecto

mvn spring-boot:run

o desde IntelliJ ejecutar:

FranchiseApiApplication.java

---

# 🐳 Ejecución con Docker

## Requisitos

- Docker Desktop

## Levantar Proyecto

docker compose up --build

## Servicios creados

- API Spring Boot
- Base de datos MySQL

---

# 🌐 Swagger UI

Acceder a la documentación interactiva:

http://localhost:8080/swagger-ui.html

---

# 📌 Endpoints Implementados

## Franquicias

### Crear franquicia

POST /api/franchises

Body:

{
  "name": "McDonalds"
}

### Actualizar nombre franquicia

PUT /api/franchises/{id}/name?name=NuevoNombre

---

## Sucursales

### Crear sucursal

POST /api/franchises/{franchiseId}/branches

Body:

{
  "name": "Sucursal Medellin"
}

### Actualizar nombre sucursal

PUT /api/franchises/branches/{id}/name?name=NuevoNombre

---

## Productos

### Crear producto

POST /api/branches/{branchId}/products

Body:

{
  "name": "Big Mac",
  "stock": 50
}

### Eliminar producto

DELETE /api/branches/{branchId}/products/{productId}

### Actualizar stock

PUT /api/products/{productId}/stock?stock=100

### Actualizar nombre producto

PUT /api/products/{id}/name?name=NuevoNombre

---

# 📊 Reporte Especial

## Producto con mayor stock por sucursal

GET /api/franchises/{id}/top-stock-products

Respuesta:

[
  {
    "branch": "Sucursal Medellin",
    "product": "Big Mac",
    "stock": 100
  }
]

---

# ✅ Funcionalidades Extra Implementadas

- Dockerización del proyecto
- Configuración por ambientes
- Swagger UI
- DTOs personalizados
- Arquitectura limpia por capas
- Historial Git por fases
- Relaciones JPA correctamente modeladas

---

# 📈 Decisiones Técnicas

## MySQL

Se eligió MySQL por consistencia relacional y facilidad para modelar:

- Franquicia 1:N Sucursal
- Sucursal 1:N Producto

## Spring Boot

Framework robusto, estándar empresarial y alta productividad.

## Docker

Permite levantar la solución completa con un solo comando.

---

# 👨‍💻 Autor

Juan Felipe Acevedo Zapata

---

# 📬 Estado Final

Proyecto funcional, dockerizado y listo para evaluación técnica.
