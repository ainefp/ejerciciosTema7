package com.example.ejercicio601.config;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.ejercicio601.exception.GlobalExceptionHandler;

import jakarta.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:/aplicacion/aplicacion.properties")
public class AplicacionConfig {
    @Value("${fichero.errores}")
    private String FICHERO_ERRORES = "errores/errors.log";

    @PostConstruct
    public void initPacienteCostos() {
        GlobalExceptionHandler.setFicheroErrores(Paths.get(FICHERO_ERRORES));
    }
}
