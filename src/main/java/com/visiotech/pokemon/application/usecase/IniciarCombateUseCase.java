package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.Combate;
import com.visiotech.pokemon.domain.model.EstadoCombate;
import com.visiotech.pokemon.domain.model.Pokemon;
import com.visiotech.pokemon.domain.repository.CombateRepository;
import com.visiotech.pokemon.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class IniciarCombateUseCase {

    private final CombateRepository combateRepository;
    private final PokemonRepository pokemonRepository;


    public Combate execute(Long pokemon1Id, Long pokemon2Id){
        Pokemon pokemon1 = pokemonRepository.findById(pokemon1Id)
                .orElseThrow(() -> new RuntimeException("Pokemon 1 no encontrado"));
        Pokemon pokemon2 = pokemonRepository.findById(pokemon2Id)
                .orElseThrow(() -> new RuntimeException("Pokemon 2 no encontrado"));


        Combate combate = Combate.builder()
                .pokemon1(pokemon1)
                .pokemon2(pokemon2)
                .psPokemon1(pokemon1.getPsTotales())
                .psPokemon2(pokemon2.getPsTotales())
                .turnoDeQuien(pokemon1.getId())
                .estado(EstadoCombate.EN_CURSO)
                .ganador(null)
                .turnos(new ArrayList<>())
                .build();

        return combateRepository.save(combate);

    }
}
