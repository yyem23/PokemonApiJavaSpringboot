package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.Pokemon;
import com.visiotech.pokemon.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ObtenerPokemonsPorMovimientoUseCase {

    private final PokemonRepository pokemonRepository;

    public List<Pokemon> execute(Long movimientoId){
        return pokemonRepository.findByMovimientoId(movimientoId);
    }
}
