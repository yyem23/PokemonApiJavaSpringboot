package com.visiotech.pokemon.interfaces.rest;

import com.visiotech.pokemon.domain.model.Movimiento;
import com.visiotech.pokemon.domain.model.Pokemon;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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


}
