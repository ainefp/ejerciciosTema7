package com.example.ejercicio601;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ejercicio601.domain.Autor;
import com.example.ejercicio601.domain.Curso;
import com.example.ejercicio601.domain.CursoSimplificado;
import com.example.ejercicio601.domain.Influencer;
import com.example.ejercicio601.domain.Promocion;
import com.example.ejercicio601.domain.Tematica;
import com.example.ejercicio601.domain.Video;
import com.example.ejercicio601.services.Autor.AutorService;
import com.example.ejercicio601.services.Curso.CursoService;
import com.example.ejercicio601.services.CursoSimplificado.CursoSimplfService;
import com.example.ejercicio601.services.Influencer.InfluencerService;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(CursoService cursoService, AutorService autorService, InfluencerService influencerService, CursoSimplfService cursoSimplfService) {
		return args -> {
			// Crear y Añadir Autores
			Autor a1_aine = autorService.añadir(new Autor(null, "Ainé Figueroa", "ainefigueroa@gmail.com", null, null, 150.0));
			Autor a2_juan = autorService.añadir(new Autor(null, "Juan Pérez", "juanperez@gmail.com", null, null, 200.0));

			// Crear y Añadir Influencers
			Influencer i1_joaqui = influencerService.añadir(new Influencer(null, "joaquirodriguez_"));
			Influencer i2_tati = influencerService.añadir(new Influencer(null, "tatiana__lopez42"));
			Influencer i3_paqui = influencerService.añadir(new Influencer(null, "paquitaa000"));

			// Crear Cursos + Crear Videos + Meter Influencers
			Curso programacion = new Curso(null, "Programación", 50.0, Tematica.PROGRAMACION, a1_aine, null, null);
			programacion.setVideos(List.of(
				new Video(null, "Introducción a la Programación", 30000, "nLJhIpKNOSo", programacion),
				new Video(null, "Programación Orientada a Objetos", 45000, "nLJhIpKNOSo", programacion),
				new Video(null, "Java Avanzado", 40000, "nLJhIpKNOSo", programacion)
			));
			programacion.setInfluencers(List.of(
				new Promocion(null, programacion, i1_joaqui),
				new Promocion(null, programacion, i2_tati)
			));
			
			Curso redes = new Curso(null, "Redes Locales", 75.0, Tematica.REDES, a1_aine, null, null);
			redes.setVideos(List.of(
				new Video(null, "Redes Locales Básicas", 15000, "nLJhIpKNOSo", redes),
				new Video(null, "DNS y DHCP", 25000, "nLJhIpKNOSo", redes)
			));
			redes.setInfluencers(List.of(
				new Promocion(null, redes, i2_tati)
			));

			Curso sistemas = new Curso(null, "Sistemas Informáticos", 60.0, Tematica.SISTEMAS, a2_juan, null, null);
			sistemas.setVideos(List.of(
				new Video(null, "Sistemas Informáticos para Principiantes", 20000, "nLJhIpKNOSo", sistemas)
			));
			sistemas.setInfluencers(List.of(
				new Promocion(null, sistemas, i3_paqui)
			));

			// Añadir Cursos
			cursoService.añadir(programacion);
			cursoService.añadir(redes);
			cursoService.añadir(sistemas);

			// Añadir Cursos Simplificados (EJERCICIO 7.8)
			cursoSimplfService.añadir(new CursoSimplificado(null, "Programación", 50.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Bases de Datos", 45.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Desarrollo Web", 60.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Java Avanzado", 70.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Python para Principiantes", 40.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "JavaScript", 55.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "HTML y CSS", 30.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Spring Boot", 75.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Angular", 65.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "React", 65.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Node.js", 60.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Docker", 50.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Kubernetes", 80.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Microservicios", 85.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Arquitectura de Software", 90.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Testing con JUnit", 35.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Git y GitHub", 25.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "DevOps", 70.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Linux", 45.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Ciberseguridad", 85.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Machine Learning", 95.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Inteligencia Artificial", 100.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Big Data", 90.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Hadoop", 75.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Spark", 80.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Power BI", 55.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Tableau", 60.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Excel Avanzado", 40.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Scrum", 30.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Kanban", 30.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Gestión de Proyectos", 65.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "UX/UI Diseño", 50.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Figma", 35.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Photoshop", 45.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Illustrator", 45.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Marketing Digital", 55.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "SEO", 50.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "SEM", 50.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Redes Sociales", 40.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "E-commerce", 60.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "WordPress", 35.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "WooCommerce", 45.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Blockchain", 95.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Criptomonedas", 85.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Realidad Virtual", 90.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Realidad Aumentada", 90.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Desarrollo de Videojuegos", 100.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Programación", 50.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Redes Locales", 75.0));
			cursoSimplfService.añadir(new CursoSimplificado(null, "Sistemas Informáticos", 60.0));
		};
	}

}
