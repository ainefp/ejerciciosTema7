package com.example.ejercicio601.services.Autor;

import java.util.List;

import com.example.ejercicio601.domain.Autor;

public interface AutorService {
    Autor añadir(Autor autor);
    List<Autor> obtenerTodos();
    Autor obtenerPorId(Long id);
    Autor editar(Autor autor);
    void borrar(Long id);
}
