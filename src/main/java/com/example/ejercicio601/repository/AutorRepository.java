package com.example.ejercicio601.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicio601.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}
