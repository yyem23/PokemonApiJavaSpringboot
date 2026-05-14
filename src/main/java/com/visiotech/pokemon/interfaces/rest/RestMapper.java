package com.visiotech.pokemon.interfaces.rest;

import com.visiotech.pokemon.domain.model.Movimiento;
import com.visiotech.pokemon.domain.model.Pokemon;
import org.springframework.stereotype.Component;

import com.visiotech.pokemon.domain.model.Turno;
import com.visiotech.pokemon.domain.model.Combate;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;


@Component
public class RestMapper {

    public MovimientoResponseDTO toMovimientoResponse(Movimiento movimiento){
        return MovimientoResponseDTO.builder()
                .id(movimiento.getId())
                .nombre(movimiento.getNombre())
                .poder(movimiento.getPoder())
                .tipo(movimiento.getTipo())
                .build();
    }


    public Movimiento toMovimientoDomain(MovimientoRequestDTO dto){
        return Movimiento.builder()
                .nombre(dto.getNombre())
                .poder(dto.getPoder())
                .tipo(dto.getTipo())
                .build();
    }


    public PokemonResponseDTO toPokemonResponse(Pokemon pokemon){
        List<MovimientoResponseDTO> movimientos = pokemon.getMovimientos() == null
                ? Collections.emptyList()
                : pokemon.getMovimientos().stream()
                  .map(this::toMovimientoResponse)
                  .collect(Collectors.toList());

        return PokemonResponseDTO.builder()
                .id(pokemon.getId())
                .nombre(pokemon.getNombre())
                .tipo(pokemon.getTipo())
                .nivel(pokemon.getNivel())
                .psActuales(pokemon.getPsActuales())
                .psTotales(pokemon.getPsTotales())
                .ataqueBase(pokemon.getAtaqueBase())
                .defensaBase(pokemon.getDefensaBase())
                .ataqueEspecialBase(pokemon.getAtaqueEspecialBase())
                .defensaEspecialBase(pokemon.getDefensaEspecialBase())
                .velocidadBase(pokemon.getVelocidadBase())
                .movimientos(movimientos)
                .build();

    }


    public TurnoResponseDTO toTurnoResponse(Turno turno){
        return TurnoResponseDTO.builder()
                .id(turno.getId())
                .nombreAtacante(turno.getAtacante().getNombre())
                .nombreMovimiento(turno.getMovimiento().getNombre())
                .danio(turno.getDanio())
                .psRestantesRival(turno.getPsRestantesRival())
                .build();

    }

    public CombateResponseDTO toCombateResponse(Combate combate) {
        return CombateResponseDTO.builder()
                .id(combate.getId())
                .nombrePokemon1(combate.getPokemon1().getNombre())
                .nombrePokemon2(combate.getPokemon2().getNombre())
                .psPokemon1(combate.getPsPokemon1())
                .psPokemon2(combate.getPsPokemon2())
                .turnoDeQuien(combate.getTurnoDeQuien())
                .estado(combate.getEstado())
                .ganador(combate.getGanador() != null
                        ? combate.getGanador().getNombre()
                        : null)
                .turnos(combate.getTurnos().stream()
                        .map(this::toTurnoResponse)
                        .collect(Collectors.toList()))
                .build();
    }





}
