package com.visiotech.pokemon.domain.service;

import com.visiotech.pokemon.domain.model.Movimiento;
import com.visiotech.pokemon.domain.model.Pokemon;
import com.visiotech.pokemon.domain.model.TipoPokemon;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CombateService {

    private static final Random RANDOM = new Random();

    public int calcularDanio(Pokemon atacante, Movimiento movimiento, Pokemon rival) {
        int nivel = atacante.getNivel();
        int ataque = atacante.getAtaqueBase();
        int poder = movimiento.getPoder();
        int defensa = rival.getDefensaBase();
        double efectividad = getEfectividad(movimiento.getTipo(), rival.getTipo());
        int random = 85 + RANDOM.nextInt(16); // 85 a 100

        double danio = (((2.0 * nivel / 5 + 2) * ataque * poder / defensa) / 50)
                * efectividad
                * random / 100;

        return (int) danio;


    }


    public double getEfectividad(TipoPokemon tipoAtaque, TipoPokemon tipoDefensor) {
        // Tabla de efectividad simplificada
        return switch (tipoAtaque) {
            case FUEGO -> switch (tipoDefensor) {
                case PLANTA, BICHO -> 2.0;
                case AGUA, ROCA, FUEGO -> 0.5;
                case DRAGON -> 0.5;
                default -> 1.0;
            };

            case AGUA -> switch (tipoDefensor) {
                case FUEGO, ROCA, TIERRA -> 2.0;
                case AGUA, PLANTA, DRAGON -> 0.5;
                default -> 1.0;
            };

            case PLANTA -> switch (tipoDefensor) {
                case AGUA, ROCA, TIERRA -> 2.0;
                case FUEGO, PLANTA, BICHO, VOLADOR, DRAGON -> 0.5;
                default -> 1.0;
            };
            case ELECTRICO -> switch (tipoDefensor) {
                case AGUA, VOLADOR -> 2.0;
                case PLANTA, ELECTRICO, DRAGON -> 0.5;
                case TIERRA -> 0.0;
                default -> 1.0;
            };

            default -> 1.0;

        };

    }

}
