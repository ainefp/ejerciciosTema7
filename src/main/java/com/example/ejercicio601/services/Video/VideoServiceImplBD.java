package com.example.ejercicio601.services.Video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio601.domain.Video;
import com.example.ejercicio601.repository.VideoRepository;

@Service
public class VideoServiceImplBD implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public Video añadir(Video video) {
        return videoRepository.save(video);
    }

    public List<Video> obtenerTodos() {
        return videoRepository.findAll();
    }

    public Video obtenerPorId(Long id) throws RuntimeException {
        return videoRepository.findById(id).orElseThrow(() -> new RuntimeException("Video no encontrado con este id: " + id));
    }

    public Video editar(Video video) {
        return videoRepository.save(video);
    }

    public void borrar(Long id) {
        obtenerPorId(id);
        videoRepository.deleteById(id);
    }

}
