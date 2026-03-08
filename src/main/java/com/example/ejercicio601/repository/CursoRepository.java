package com.example.ejercicio601.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicio601.domain.Curso;
import com.example.ejercicio601.domain.Tematica;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNombreContainingIgnoreCase(String textoNombre);
    List<Curso> findByTematica(Tematica tematica);
    List<Curso> findByPrecioLessThanEqualOrderByPrecio(Double precio);
    List<Curso> findByAutorId(Long autorId);
}