package com.example.ejercicio601.services.CursoSimplificado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio601.domain.CursoSimplificado;
import com.example.ejercicio601.exception.ArchivoDuplicadoException;
import com.example.ejercicio601.exception.ArchivoNoEncontradoException;
import com.example.ejercicio601.repository.CursoSimplfRepository;


@Service
public class CursoSimplfServiceImplBD implements CursoSimplfService {
    @Autowired
    CursoSimplfRepository cursoSimplfRepository;

    public CursoSimplificado añadir(CursoSimplificado cursoSimplificado) throws RuntimeException {
        if (cursoSimplificado.getId() != null && cursoSimplfRepository.existsById(cursoSimplificado.getId())) {
            throw new ArchivoDuplicadoException("El curso ya existe con id: " + cursoSimplificado.getId());
        }
        return cursoSimplfRepository.save(cursoSimplificado);
    }

    public List<CursoSimplificado> obtenerTodos() throws RuntimeException {
        return cursoSimplfRepository.findAll();
    }

    public CursoSimplificado obtenerPorId(Long id) throws RuntimeException {
        return cursoSimplfRepository.findById(id).orElseThrow(() -> new ArchivoNoEncontradoException("Curso no encontrado con este id: " + id));
    }
}