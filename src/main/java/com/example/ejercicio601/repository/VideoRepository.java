package com.example.ejercicio601.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicio601.domain.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
    
}
