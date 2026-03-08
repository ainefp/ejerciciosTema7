package com.example.ejercicio601;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ejercicio601.domain.Autor;
import com.example.ejercicio601.domain.Curso;
import com.example.ejercicio601.domain.Tematica;
import com.example.ejercicio601.repository.AutorRepository;
import com.example.ejercicio601.services.CursoService;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(CursoService cursoService, AutorRepository autorRepository) {
		return args -> {
			Autor aine = autorRepository.save(new Autor(null, "Ainé Figueroa", "ainefigueroa@gmail.com"));
			Autor juan = autorRepository.save(new Autor(null, "Juan Pérez", "juanperez@gmail.com"));
			Autor maria = autorRepository.save(new Autor(null, "María García", "mariagarcia@gmail.com"));

			cursoService.añadir(new Curso(null, "Programación", 50.0, Tematica.PROGRAMACION, aine));
			cursoService.añadir(new Curso(null, "Redes Locales", 75.0, Tematica.REDES, juan));
			cursoService.añadir(new Curso(null, "Sistemas Informáticos", 60.0, Tematica.SISTEMAS, maria));
		};
	}

}
