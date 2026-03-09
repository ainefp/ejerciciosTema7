package com.example.ejercicio601.services.Curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio601.domain.Curso;
import com.example.ejercicio601.domain.Tematica;
import com.example.ejercicio601.domain.Video;
import com.example.ejercicio601.repository.CursoRepository;


@Service
public class CursoServiceImplBD implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    
    public Curso añadir(Curso curso) {
        validarLimiteCoste(curso);
        return cursoRepository.save(curso);
    }
    
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    
    public Curso obtenerPorId(Long id) throws RuntimeException {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso no encontrado con este id: " + id));
    }

    public Curso editar(Curso curso) {
        validarLimiteCoste(curso);
        return cursoRepository.save(curso);
    }

    public void borrar(Long id) {
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

    public List<Curso> buscarPorAutor(Long autorId) {
        return cursoRepository.findByAutorId(autorId);
    }

    private void validarLimiteCoste(Curso curso) {
        Long idAutor = curso.getAutor().getId();
        Double costeTotal = cursoRepository.obtenerSumaCostesPorAutor(idAutor);
        Double limiteCosteTotal = curso.getAutor().getLimiteCostoTotalCursos();

        if (costeTotal + curso.getPrecio() > limiteCosteTotal) {
            throw new RuntimeException("El coste total de los cursos de " + curso.getAutor().getNombre() + " no puede superar los " + limiteCosteTotal);
        }
    }
}