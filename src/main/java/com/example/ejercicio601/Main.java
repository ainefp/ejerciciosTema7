package com.example.ejercicio601;

import java.util.List;
import java.util.zip.Inflater;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ejercicio601.domain.Autor;
import com.example.ejercicio601.domain.Curso;
import com.example.ejercicio601.domain.Influencer;
import com.example.ejercicio601.domain.Tematica;
import com.example.ejercicio601.domain.Video;
import com.example.ejercicio601.services.Autor.AutorService;
import com.example.ejercicio601.services.Curso.CursoService;
import com.example.ejercicio601.services.Influencer.InfluencerService;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(CursoService cursoService, AutorService autorService, InfluencerService influencerService) {
		return args -> {
			// Crear y Añadir Autores
			Autor a1_aine = autorService.añadir(new Autor(null, "Ainé Figueroa", "ainefigueroa@gmail.com", null, null, 150.0));
			Autor a2_juan = autorService.añadir(new Autor(null, "Juan Pérez", "juanperez@gmail.com", null, null, 200.0));

			// Crear y Añadir Influencers
			Influencer i1_joaqui = influencerService.añadir(new Influencer(null, "joaquirodriguez_"));
			Influencer i2_tati = influencerService.añadir(new Influencer(null, "tatiana__lopez42"));
			Influencer i3_paqui = influencerService.añadir(new Influencer(null, "paquitaa000"));

			// Crear Cursos + Crear Videos
			Curso programacion = new Curso(null, "Programación", 50.0, Tematica.PROGRAMACION, a1_aine, null);
			programacion.setVideos(List.of(
				new Video(null, "Introducción a la Programación", 30000, "nLJhIpKNOSo", programacion),
				new Video(null, "Programación Orientada a Objetos", 45000, "nLJhIpKNOSo", programacion),
				new Video(null, "Java Avanzado", 40000, "nLJhIpKNOSo", programacion)
			));
			
			Curso redes = new Curso(null, "Redes Locales", 75.0, Tematica.REDES, a1_aine, null);
			redes.setVideos(List.of(
				new Video(null, "Redes Locales Básicas", 15000, "nLJhIpKNOSo", redes),
				new Video(null, "DNS y DHCP", 25000, "nLJhIpKNOSo", redes)
			));

			Curso sistemas = new Curso(null, "Sistemas Informáticos", 60.0, Tematica.SISTEMAS, a2_juan, null);
			sistemas.setVideos(List.of(
				new Video(null, "Sistemas Informáticos para Principiantes", 20000, "nLJhIpKNOSo", sistemas)
			));

			// Añadir Cursos
			cursoService.añadir(programacion);
			cursoService.añadir(redes);
			cursoService.añadir(sistemas);
		};
	}

}
