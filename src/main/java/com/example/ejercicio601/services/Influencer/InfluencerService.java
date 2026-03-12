package com.example.ejercicio601.services.Influencer;

import java.util.List;

import com.example.ejercicio601.domain.Influencer;

public interface InfluencerService {
    Influencer añadir(Influencer influencer);
    List<Influencer> obtenerTodos();
    Influencer obtenerPorId(Long id);
    Influencer editar(Influencer influencer);
    void borrar(Long id);
}
