package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.Pokemon;
import com.visiotech.pokemon.domain.model.TipoPokemon;
import com.visiotech.pokemon.domain.repository.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class GuardarPokemonUseCaseTest {


    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    private GuardarPokemonUseCase guardarPokemonUseCase;

    @Test
    void debeGuardarPokemonCorrectamente(){
        Pokemon pokemon= Pokemon.builder()
                .nombre("Pikachu")
                .tipo(TipoPokemon.ELECTRICO)
                .nivel(25)
                .psActuales(100)
                .psTotales(100)
                .ataqueBase(55)
                .defensaBase(40)
                .ataqueEspecialBase(50)
                .defensaEspecialBase(50)
                .velocidadBase(90)
                .movimientos(Collections.emptyList())
                .build();

        when(pokemonRepository.save(pokemon)).thenReturn(pokemon);

        Pokemon resultado = guardarPokemonUseCase.execute(pokemon);

        assertNotNull(resultado);
        assertEquals("Pikachu", resultado.getNombre());
        assertEquals(TipoPokemon.ELECTRICO, resultado.getTipo());
        verify(pokemonRepository).save(pokemon);
    }
}
