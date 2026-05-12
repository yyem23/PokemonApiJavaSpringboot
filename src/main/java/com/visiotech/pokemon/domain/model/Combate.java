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
public class Combate {

    private Long id;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private int psPokemon1;
    private int psPokemon2;
    private Long turnoDeQuien; // id del pokemon que debe atacar
    private EstadoCombate estado;
    private Pokemon ganador;
    private List<Turno> turnos;

}
