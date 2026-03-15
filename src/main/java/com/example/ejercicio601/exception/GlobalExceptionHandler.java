package com.example.ejercicio601.exception;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.net.URLEncoder;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Path FICHERO_ERRORES = Paths.get("errors/errors.log");
    
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

    private void registrarError(ErrorResponse error) {
        try {
            Files.createDirectories(FICHERO_ERRORES.getParent());
            String linea = error.getFecha() + " | " + error.getTipoError() + " | " + error.getMsg() + System.lineSeparator();
            Files.writeString(FICHERO_ERRORES, linea, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            // Manejar la excepción sin interrumpir el flujo normal
        }
    }
}
