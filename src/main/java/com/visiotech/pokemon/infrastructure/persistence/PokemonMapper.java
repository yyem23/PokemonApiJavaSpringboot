package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.Pokemon;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PokemonMapper {

    private final MovimientoMapper movimientoMapper;

    public PokemonMapper(MovimientoMapper movimientoMapper){
        this.movimientoMapper=movimientoMapper;
    }


    public Pokemon toDomain(PokemonEntity entity){
        return Pokemon.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .tipo(entity.getTipo())
                .nivel(entity.getNivel())
                .psActuales(entity.getPsActuales())
                .psTotales(entity.getPsTotales())
                .ataqueBase(entity.getAtaqueBase())
                .defensaBase(entity.getDefensaBase())
                .ataqueEspecialBase(entity.getAtaqueEspecialBase())
                .defensaEspecialBase(entity.getDefensaEspecialBase())
                .velocidadBase(entity.getVelocidadBase())
                .movimientos(entity.getMovimientos().stream()
                        .map(movimientoMapper::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }


    public PokemonEntity toEntity(Pokemon domain){
        return PokemonEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .tipo(domain.getTipo())
                .nivel(domain.getNivel())
                .psActuales(domain.getPsActuales())
                .psTotales(domain.getPsTotales())
                .ataqueBase(domain.getAtaqueBase())
                .defensaBase(domain.getDefensaBase())
                .ataqueEspecialBase(domain.getAtaqueEspecialBase())
                .defensaEspecialBase(domain.getDefensaEspecialBase())
                .velocidadBase(domain.getVelocidadBase())
                .movimientos(domain.getMovimientos().stream()
                        .map(movimientoMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();







    }

}
