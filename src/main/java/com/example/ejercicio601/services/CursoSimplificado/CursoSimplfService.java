package com.example.ejercicio601.services.CursoSimplificado;

import java.util.List;

import com.example.ejercicio601.domain.CursoSimplificado;

public interface CursoSimplfService {
    CursoSimplificado añadir(CursoSimplificado cursoSimplificado);
    List<CursoSimplificado> obtenerTodos();
    CursoSimplificado obtenerPorId(Long id);
}
