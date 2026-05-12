package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.Pokemon;
import com.visiotech.pokemon.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObtenerPokemonUseCase {

    private final PokemonRepository pokemonRepository;

    public Optional<Pokemon> execute(Long id){
        return pokemonRepository.findById(id);
    }
}
