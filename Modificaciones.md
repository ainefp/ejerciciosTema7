# Modificaciones del ejercicio 7.5

> Resumen de los cambios aplicados en la práctica.

## Estructura del proyecto

- Templates divididos en carpetas (`Autor`, `Curso`, `Influencer`, `Video`)
- Referencia en vistas: `Curso/listCursoView`

## ModelAttribute

- Implementado en los controladores para evitar `model.addAttribute` innecesarios

## Sistema de Gestión de errores con `ControllerAdvice`

### Incluye

- Clase `ErrorResponse` con los datos necesarios
- Excepciones personalizadas + Excepción genérica
- Mensajes de error a la vista (se escriben en el Servicio)

### Almacenamiento de errores

- Ruta del fichero: `errores/errors.log`

### Estructura del registro

- `LocalDateTime.now()`, `getClass` y `getMessage`
