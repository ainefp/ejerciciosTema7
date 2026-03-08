package com.example.ejercicio601.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicio601.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNombre(String nombre);
}
