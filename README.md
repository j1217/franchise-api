# 🚀 Franchise API

Prueba técnica backend desarrollada en Spring Boot para la administración de franquicias, sucursales y productos, aplicando buenas prácticas de desarrollo, enfoque arquitectónico limpio, pruebas automatizadas y despliegue contenerizado.

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
- Facilidad de despliegue
- Calidad mediante pruebas automatizadas

---

# 🛠️ Tecnologías Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL 8
- Maven
- JUnit 5
- Mockito
- Swagger / OpenAPI
- Docker
- Docker Compose
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
- service: Casos de uso y lógica de negocio
- repository: Acceso a datos y persistencia
- entity: Modelo de dominio relacional
- dto: Objetos de transferencia de datos

---

# 🧩 Enfoque Clean Architecture

Aunque se desarrolló una solución pragmática para la prueba técnica, la estructura fue organizada siguiendo principios de Clean Architecture:

- Separación clara entre capa de entrada (controllers) y lógica de negocio (services)
- Persistencia desacoplada mediante interfaces repository
- Dominio representado por entidades independientes
- DTOs para evitar exponer internamente el modelo de datos
- Código preparado para evolucionar hacia puertos y adaptadores si el proyecto crece

Esto facilita:

- Mantenimiento
- Escalabilidad
- Testabilidad
- Bajo acoplamiento

---

# ⚡ Programación Reactiva

Como parte de los criterios de evaluación, se aplicó programación funcional/reactiva en operaciones de procesamiento de datos mediante Java Streams.

Ejemplo implementado:

- Búsqueda del producto con mayor stock por sucursal usando stream(), max() y Comparator

Esto permite:

- Código declarativo
- Mejor legibilidad
- Menor complejidad imperativa
- Fácil evolución hacia un stack totalmente reactivo (Spring WebFlux / Reactor) si el proyecto lo requiere

---

# 🧪 Pruebas Unitarias

Se implementaron pruebas unitarias con JUnit 5 y Mockito sobre la lógica principal del sistema.

Cobertura aplicada a:

- Creación de franquicias
- Actualización de stock de productos
- Reporte de producto con mayor stock por sucursal

Ubicación:

src/test/java/com/accenture/franchiseapi/service/

Ejecución:

mvn test

Beneficios:

- Validación automática del comportamiento esperado
- Prevención de regresiones
- Mayor confiabilidad del código
- Base sólida para integración continua

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

# 🏗️ Infrastructure as Code (IaC)

Se incorporó enfoque Infrastructure as Code mediante Docker Compose, definiendo la infraestructura necesaria para ejecutar la solución de forma declarativa.

Archivo principal:

docker-compose.yml

Servicios definidos:

- API Spring Boot
- Base de datos MySQL

Ventajas:

- Reproducibilidad del entorno
- Configuración estandarizada
- Inicio rápido con un solo comando
- Menor dependencia de configuraciones manuales

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
- Pruebas unitarias
- Clean Architecture aplicada de forma pragmática
- Programación funcional con Streams
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

## Testing

Se priorizó validar la lógica crítica mediante pruebas unitarias desacopladas.

---

# 👨‍💻 Autor

Juan Felipe Acevedo Zapata

---

# 📬 Estado Final

Proyecto funcional, probado, dockerizado y listo para evaluación técnica.
