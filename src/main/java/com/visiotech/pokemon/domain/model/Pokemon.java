package com.visiotech.pokemon.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {


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


    private List<Movimiento> movimientos;

}
