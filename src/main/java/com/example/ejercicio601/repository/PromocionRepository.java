package com.example.ejercicio601.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicio601.domain.Promocion;

public interface PromocionRepository extends JpaRepository<Promocion, Long> {
    List<Promocion> findByInfluencerId(Long influencerId);
}
