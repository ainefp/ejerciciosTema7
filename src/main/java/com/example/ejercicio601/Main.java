package com.example.ejercicio601;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ejercicio601.domain.Curso;
import com.example.ejercicio601.domain.Tematica;
import com.example.ejercicio601.services.CursoService;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(CursoService cursoService) {
		return args -> {
			cursoService.añadir(new Curso(null, "Programación", 50.0, Tematica.PROGRAMACION));
			cursoService.añadir(new Curso(null, "Redes Locales", 75.0, Tematica.REDES));
			cursoService.añadir(new Curso(null, "Sistemas Informáticos", 60.0, Tematica.SISTEMAS));
		};
	}

}
