package com.visiotech.pokemon.interfaces.rest;

import com.visiotech.pokemon.domain.model.TipoPokemon;
import lombok.Builder;
import lombok.Getter;


import java.util.List;


@Getter
@Builder
public class PokemonResponseDTO {

    private Long id;
    private String nombre;
    private TipoPokemon tipo;
    private int nivel;
    private int psActuales;
    private int psTotales;
    private int ataqueBase;
    private int defensaBase;
    private int ataqueEspecialBase;
    private int defensaEspecialBase;
    private int velocidadBase;
    private List<MovimientoResponseDTO> movimientos;

}
