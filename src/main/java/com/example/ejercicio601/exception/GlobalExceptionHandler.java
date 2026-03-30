package com.example.ejercicio601.exception;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Path FICHERO_ERRORES;
    
    // Excepciones generalizadas
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), LocalDateTime.now(), ex.getClass().getSimpleName());
        registrarError(error);
        return redireccionConError(request, error.getMsg());
    }

    // Excepciones por recursos no encontrados
    @ExceptionHandler(ArchivoNoEncontradoException.class)
    public String handleArchivoNoEncontradoException(ArchivoNoEncontradoException ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), LocalDateTime.now(), ex.getClass().getSimpleName());
        registrarError(error);
        return redireccionConError(request, error.getMsg());
    }

    // Excepciones por recursos duplicados
    @ExceptionHandler(ArchivoDuplicadoException.class)
    public String handleArchivoDuplicadoException(ArchivoDuplicadoException ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), LocalDateTime.now(), ex.getClass().getSimpleName());
        registrarError(error);
        return redireccionConError(request, error.getMsg());
    }

    // Le pasa el error a la vista correspondiente
    private String redireccionConError(HttpServletRequest request, String mensaje) {
        String uri = request.getRequestURI();
        String destino = "/list";

        if (uri.startsWith("/autores")) {
            destino = "/autores";
        } else if (uri.startsWith("/influencers")) {
            destino = "/influencers";
        } else if (uri.startsWith("/videos")) {
            destino = "/videos";
        }

        String msgCodificado = URLEncoder.encode(mensaje, StandardCharsets.UTF_8);
        return "redirect:" + destino + "?errorMsg=" + msgCodificado;
    }

    // Registra el error en el archivo de errores
    private void registrarError(ErrorResponse error) {
        try {
            Files.createDirectories(FICHERO_ERRORES.getParent());
            String linea = error.getFecha() + " | " + error.getTipoError() + " | " + error.getMsg() + System.lineSeparator();
            Files.writeString(FICHERO_ERRORES, linea, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            // Manejar la excepción sin interrumpir el flujo normal
        }
    }

    public static void setFicheroErrores(Path ruta) {
        FICHERO_ERRORES = ruta;
    }
}
