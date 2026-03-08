package com.example.ejercicio601.services;

import java.util.List;

import com.example.ejercicio601.domain.Curso;
import com.example.ejercicio601.domain.Tematica;

public interface CursoService {
    Curso añadir(Curso curso);
    List<Curso> obtenerTodos();
    Curso obtenerPorId(Long id);
    Curso editar(Curso curso);
    void borrar(Long id);
    List<Curso> buscarPorNombre(String textoNombre);
    List<Curso> buscarPorTematica(Tematica textoTematica);
    List<Curso> buscarPorPrecioMenor(Double precio);
    List<Curso> buscarPorAutor(Long autorId);
}
