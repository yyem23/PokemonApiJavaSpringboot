package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.Pokemon;
import com.visiotech.pokemon.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GuardarPokemonUseCase {

    private final PokemonRepository pokemonRepository;

    public Pokemon execute(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }


}
