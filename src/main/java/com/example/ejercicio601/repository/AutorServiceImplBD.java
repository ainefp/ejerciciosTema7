package com.example.ejercicio601.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio601.domain.Autor;
import com.example.ejercicio601.services.AutorService;

@Service
public class AutorServiceImplBD implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor añadir(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    public Autor obtenerPorId(Long id) throws RuntimeException {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado con este id: " + id));
    }

    public Autor editar(Autor autor) {
        return autorRepository.save(autor);
    }

    public void borrar(Long id) {
        obtenerPorId(id);
        autorRepository.deleteById(id);
    }

    public List<Autor> obtenerPorNombre(String nombre) {
        return autorRepository.findByNombre(nombre);
    }
}
