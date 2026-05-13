package com.visiotech.pokemon.domain.repository;

import com.visiotech.pokemon.domain.model.Combate;

import java.util.Optional;

public interface CombateRepository {


    Combate save(Combate combate);
    Optional<Combate> findById(Long id);
}
