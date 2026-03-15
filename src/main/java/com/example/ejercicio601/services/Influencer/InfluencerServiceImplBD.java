package com.example.ejercicio601.services.Influencer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ejercicio601.domain.Influencer;
import com.example.ejercicio601.exception.ArchivoDuplicadoException;
import com.example.ejercicio601.exception.ArchivoNoEncontradoException;
import com.example.ejercicio601.repository.InfluencerRepository;

@Service
public class InfluencerServiceImplBD implements InfluencerService {

    @Autowired
    private InfluencerRepository influencerRepository;

    public Influencer añadir(Influencer influencer) throws RuntimeException {
        if (influencer.getId() != null && influencerRepository.existsById(influencer.getId())) {
            throw new ArchivoDuplicadoException("El influencer ya existe con id: " + influencer.getId());
        }
        return influencerRepository.save(influencer);
    }

    public List<Influencer> obtenerTodos() {
        return influencerRepository.findAll();
    }

    public Influencer obtenerPorId(Long id) throws RuntimeException {
        return influencerRepository.findById(id).orElseThrow(() -> new ArchivoNoEncontradoException("Influencer no encontrado con este id: " + id));
    }

    public Influencer editar(Influencer influencer) throws RuntimeException {
        obtenerPorId(influencer.getId());
        return influencerRepository.save(influencer);
    }

    public void borrar(Long id) throws RuntimeException {
        obtenerPorId(id);
        influencerRepository.deleteById(id);
    }

}
