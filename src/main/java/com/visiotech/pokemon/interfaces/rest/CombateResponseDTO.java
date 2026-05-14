package com.visiotech.pokemon.interfaces.rest;

import com.visiotech.pokemon.domain.model.EstadoCombate;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
@Builder
public class CombateResponseDTO {

    private Long id;
    private String nombrePokemon1;
    private String nombrePokemon2;
    private int psPokemon1;
    private int psPokemon2;
    private Long turnoDeQuien;
    private EstadoCombate estado;
    private String ganador;
    private List<TurnoResponseDTO> turnos;
}
