package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EliminarPokemonUseCase {

    private final PokemonRepository pokemonRepository;

    public void excute(Long id){
        pokemonRepository.deleteById(id);
    }
}
