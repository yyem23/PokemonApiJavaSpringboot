package com.visiotech.pokemon.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movimiento {

    private Long id;
    private String nombre;
    private int poder;
    private TipoPokemon tipo;



}
