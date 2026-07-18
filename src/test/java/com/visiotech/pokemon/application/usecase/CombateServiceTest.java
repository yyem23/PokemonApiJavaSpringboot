package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.*;
import com.visiotech.pokemon.domain.service.CombateService;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CombateServiceTest {

    private final CombateService combateService = new CombateService();

    @Test
    void  cularDanioPositivo() {
        Pokemon atacante = Pokemon.builder()
                .nivel(50)
                .ataqueBase(84)
                .defensaBase(78)
                .movimientos(Collections.emptyList())
                .tipo(TipoPokemon.FUEGO)
                .build();

        Pokemon defensor = Pokemon.builder()
                .nivel(50)
                .ataqueBase(55)
                .defensaBase(40)
                .movimientos(Collections.emptyList())
                .tipo(TipoPokemon.ELECTRICO)
                .build();

        Movimiento movimiento = Movimiento.builder()
                .nombre("Lanzallamas")
                .poder(90)
                .tipo(TipoPokemon.FUEGO)
                .build();

        int danio = combateService.calcularDanio(atacante, movimiento, defensor);

        assertTrue(danio > 0);
    }

    @Test
    void danioDeBeFuerteContraPlanta() {
        Pokemon atacante = Pokemon.builder()
                .nivel(50)
                .ataqueBase(84)
                .defensaBase(78)
                .movimientos(Collections.emptyList())
                .tipo(TipoPokemon.FUEGO)
                .build();

        Pokemon defensorPlanta = Pokemon.builder()
                .nivel(50)
                .ataqueBase(55)
                .defensaBase(40)
                .movimientos(Collections.emptyList())
                .tipo(TipoPokemon.PLANTA)
                .build();

        Pokemon defensorAgua = Pokemon.builder()
                .nivel(50)
                .ataqueBase(55)
                .defensaBase(40)
                .movimientos(Collections.emptyList())
                .tipo(TipoPokemon.AGUA)
                .build();

        Movimiento movimiento = Movimiento.builder()
                .nombre("Lanzallamas")
                .poder(90)
                .tipo(TipoPokemon.FUEGO)
                .build();

        int danioContraPlanta = combateService.calcularDanio(atacante, movimiento, defensorPlanta);
        int danioContraAgua = combateService.calcularDanio(atacante, movimiento, defensorAgua);

        assertTrue(danioContraPlanta > danioContraAgua);
    }
}