package com.visiotech.pokemon.domain.repository;


import com.visiotech.pokemon.domain.model.Pokemon;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository {

    Pokemon save(Pokemon pokemon);
    Optional<Pokemon> findById(Long id);
    List<Pokemon> findAll();
    void deleteById(Long id);


}
