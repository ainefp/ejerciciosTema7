package com.example.ejercicio601.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicio601.domain.CursoSimplificado;

public interface CursoSimplfRepository extends JpaRepository<CursoSimplificado, Long> {
    
}