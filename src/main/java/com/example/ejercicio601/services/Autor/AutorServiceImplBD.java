package com.example.ejercicio601.services.Autor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio601.domain.Autor;
import com.example.ejercicio601.repository.AutorRepository;

@Service
public class AutorServiceImplBD implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor añadir(Autor autor) throws RuntimeException {
        if (autor.getId() != null && autorRepository.existsById(autor.getId())) {
            throw new RuntimeException("El autor ya existe con id: " + autor.getId());
        }
        return autorRepository.save(autor);
    }

    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    public Autor obtenerPorId(Long id) throws RuntimeException {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado con este id: " + id));
    }

    public Autor editar(Autor autor) throws RuntimeException {
        obtenerPorId(autor.getId());
        return autorRepository.save(autor);
    }

    public void borrar(Long id) throws RuntimeException {
        obtenerPorId(id);
        autorRepository.deleteById(id);
    }

}
