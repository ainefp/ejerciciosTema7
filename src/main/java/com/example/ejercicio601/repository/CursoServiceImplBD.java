package com.example.ejercicio601.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio601.domain.Curso;
import com.example.ejercicio601.domain.Tematica;
import com.example.ejercicio601.services.CursoService;


@Service
public class CursoServiceImplBD implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    
    public Curso añadir(Curso curso) {
        return cursoRepository.save(curso);
    }
    
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    
    public Curso obtenerPorId(Long id) throws RuntimeException {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso no encontrado con este id: " + id));
    }

    public Curso editar(Curso curso) throws RuntimeException {
        return cursoRepository.save(curso);
    }

    public void borrar(Long id) throws RuntimeException {
        obtenerPorId(id);
        cursoRepository.deleteById(id);
    }

    public List<Curso> buscarPorNombre(String textoNombre) {
        return cursoRepository.findByNombreContainingIgnoreCase(textoNombre);
    }

    public List<Curso> buscarPorTematica(Tematica textoTematica) {
        return cursoRepository.findByTematica(textoTematica);
    }

    public List<Curso> buscarPorPrecio(Double precio) {
        return cursoRepository.findByPrecioLessThanEqualOrderByPrecio(precio);
    }

    public List<Curso> buscarPorPrecioMenor(Double precio) {
        return cursoRepository.findByPrecioLessThanEqualOrderByPrecio(precio);
    }
}