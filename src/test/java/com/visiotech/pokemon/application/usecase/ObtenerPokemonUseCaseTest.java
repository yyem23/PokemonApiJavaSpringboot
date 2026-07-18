package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.NotFoundException;
import com.visiotech.pokemon.domain.model.Pokemon;
import com.visiotech.pokemon.domain.model.TipoPokemon;
import com.visiotech.pokemon.domain.repository.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerPokemonUseCaseTest {


    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private ObtenerPokemonUseCase obtenerPokemonUseCase;


    @Test
    void debeRetornarPokemonCuandoExiste(){
        Pokemon pokemon = Pokemon.builder()
                .id(1L)
                .nombre("Charizard")
                .tipo(TipoPokemon.FUEGO)
                .nivel(50)
                .psActuales(150)
                .psTotales(150)
                .ataqueBase(84)
                .defensaBase(78)
                .ataqueEspecialBase(109)
                .defensaEspecialBase(85)
                .velocidadBase(100)
                .movimientos(Collections.emptyList())
                .build();



        when(pokemonRepository.findById(1L)).thenReturn(Optional.of(pokemon));

        Optional<Pokemon> resultado = obtenerPokemonUseCase.execute(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Charizard", resultado.get().getNombre());

    }


    @Test
    void debeRetornarVacioCuandoNoExiste(){
        when(pokemonRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Pokemon> resultado = obtenerPokemonUseCase.execute(99L);

        assertFalse(resultado.isPresent());
    }

}
