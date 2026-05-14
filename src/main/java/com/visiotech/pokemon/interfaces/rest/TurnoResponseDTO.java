package com.visiotech.pokemon.interfaces.rest;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TurnoResponseDTO {

    private Long id;
    private String nombreAtacante;
    private String nombreMovimiento;
    private int danio;
    private int psRestantesRival;


}
