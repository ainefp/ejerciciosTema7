package com.example.ejercicio601.services.CursoSimplificado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ejercicio601.domain.CursoSimplificado;
import com.example.ejercicio601.exception.ArchivoDuplicadoException;
import com.example.ejercicio601.exception.ArchivoNoEncontradoException;
import com.example.ejercicio601.repository.CursoSimplfRepository;


@Service
public class CursoSimplfServiceImplBD implements CursoSimplfService {
    @Autowired
    CursoSimplfRepository cursoSimplfRepository;

    private final Integer PAGE_SIZE = 10;

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

    public int getTotalPaginas() {
        Pageable paging = PageRequest.of(0, PAGE_SIZE, Sort.by("id").descending());
        Page<CursoSimplificado> pagedResult = cursoSimplfRepository.findAll(paging);
        return pagedResult.getTotalPages();
    }

    public List<CursoSimplificado> getCursosPaginados(Integer numPag) {
        Pageable paging = PageRequest.of(numPag, PAGE_SIZE, Sort.by("id"));  // Por defecto es ascending
        Page<CursoSimplificado> pagedResult = cursoSimplfRepository.findAll(paging);
        return pagedResult.hasContent() ? pagedResult.getContent() : List.of();
    }
}