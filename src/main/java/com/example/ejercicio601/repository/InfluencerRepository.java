package com.example.ejercicio601.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicio601.domain.Influencer;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
    
}
