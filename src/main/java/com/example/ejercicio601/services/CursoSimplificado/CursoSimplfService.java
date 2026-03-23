package com.example.ejercicio601.services.CursoSimplificado;

import java.util.List;

import com.example.ejercicio601.domain.CursoSimplificado;

public interface CursoSimplfService {
    CursoSimplificado añadir(CursoSimplificado cursfoSimplificado);
    List<CursoSimplificado> obtenerTodos();
    CursoSimplificado obtenerPorId(Long id);
    int getTotalPaginas();
    List<CursoSimplificado> getCursosPaginados(Integer numPag);
}
