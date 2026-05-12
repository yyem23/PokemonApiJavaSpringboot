package com.visiotech.pokemon.interfaces.rest;

import com.visiotech.pokemon.domain.model.TipoPokemon;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class MovimientoResponseDTO {

    private Long id;
    private String nombre;
    private int poder;
    private TipoPokemon tipo;
}
