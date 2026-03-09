package com.example.ejercicio601.services.Video;

import java.util.List;

import com.example.ejercicio601.domain.Video;

public interface VideoService {
    Video añadir(Video video);
    List<Video> obtenerTodos();
    Video obtenerPorId(Long id);
    Video editar(Video video);
    void borrar(Long id);
}
