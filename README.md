# Ejercicios del tema 7 (7.1-7.5, 7.8)

> Resumen de los cambios aplicados en la práctica.

## Estructura del proyecto

- Services y Templates divididos en carpetas: `Autor`, `Curso`, `Influencer`, `Video`, `CursoSimplificado`.
- Referencia en vistas: `Curso/listCursoView`.


## ModelAttribute

  - Implementado en los controladores para evitar `model.addAttribute` innecesarios.


## Sistema de Gestión de errores con `ControllerAdvice`

### Incluye

  - Clase `ErrorResponse` con los datos necesarios.
  - Excepciones personalizadas + Excepción genérica.
  - Mensajes de error a la vista (se escriben en el Servicio).

### Almacenamiento de errores

  - Ruta del fichero: `errores/errors.log`.

### Estructura del registro

  - `LocalDateTime.now()`, `getClass` y `getMessage`.


## Inicialización de datos

### Incluye

  - Inserts para todas las entidades principales: `Autor`, `Influencer`, `Curso`, `Video`, `Promocion` y `CursoSimplificado`.

### Configuración
  - Habilitado en el aplication.properties.
  - Datos almacenados en `src/main/resources/data.sql`.


## Módulo `CursoSimplificado` (Ejercicio 7.8)

### Características
  - Implementación aislada basada en el ejercicio 7.1, que representa un curso con atributos mínimos.
  - No se integra con el resto de las entidades de la aplicación.
  - Ofrece un **CRUD básico** y **paginación** en su listado.

### Ubicación
  - Los ficheros relacionados se encuentran en `domain/CursoSimplificado`, `services/CursoSimplificado` y `templates/CursoSimplificado`.

### Gestión de la Configuración

  - **Configuración Principal**: El fichero `application.properties` define las propiedades estándar de Spring Boot (puerto, base de datos, H2-console, etc.).
  - **Variables Personalizadas**: Se utiliza un fichero `aplicacion.properties` para almacenar valores específicos de la aplicación, como la ruta al log de errores.
  - **Carga de Propiedades**: La clase `config/AplicacionConfig.java` se encarga de leer y exponer estas variables personalizadas dentro de la aplicación.