package com.example.ejercicio601.services.Video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio601.domain.Video;
import com.example.ejercicio601.exception.ArchivoDuplicadoException;
import com.example.ejercicio601.exception.ArchivoNoEncontradoException;
import com.example.ejercicio601.repository.VideoRepository;

@Service
public class VideoServiceImplBD implements VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public Video añadir(Video video) throws RuntimeException {
        if (video.getId() != null && videoRepository.existsById(video.getId())) {
            throw new ArchivoDuplicadoException("El video ya existe con id: " + video.getId());
        }
        return videoRepository.save(video);
    }

    public List<Video> obtenerTodos() throws RuntimeException {
        return videoRepository.findAll();
    }

    public Video obtenerPorId(Long id) throws RuntimeException {
        return videoRepository.findById(id).orElseThrow(() -> new ArchivoNoEncontradoException("Video no encontrado con este id: " + id));
    }

    public Video editar(Video video) throws RuntimeException {
        obtenerPorId(video.getId());
        return videoRepository.save(video);
    }

    public void borrar(Long id) throws RuntimeException {
        obtenerPorId(id);
        videoRepository.deleteById(id);
    }

}
