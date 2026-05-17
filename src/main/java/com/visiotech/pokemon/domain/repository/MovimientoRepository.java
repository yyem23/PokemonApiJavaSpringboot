package com.visiotech.pokemon.domain.repository;

import com.visiotech.pokemon.domain.model.Movimiento;
import com.visiotech.pokemon.domain.model.TipoPokemon;

import java.util.List;
import java.util.Optional;

public interface MovimientoRepository {

    Movimiento save(Movimiento movimiento);
    Optional<Movimiento> findById(Long id);
    List<Movimiento> findAll();
    void deleteById(Long id);
    List<Movimiento> findByTipo(TipoPokemon tipo);
    List<Movimiento> findByPokemonId(Long pokemonId);

}
