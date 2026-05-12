package com.visiotech.pokemon.domain.model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Turno {

    private Long id;
    private Pokemon atacante;
    private Movimiento movimiento;
    private int danio;
    private int psRestantesRival;

}
