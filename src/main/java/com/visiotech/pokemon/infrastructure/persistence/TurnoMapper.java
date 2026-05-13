package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.Turno;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TurnoMapper {

    private final PokemonMapper pokemonMapper;
    private final MovimientoMapper movimientoMapper;

    public Turno toDomain(TurnoEntity entity) {
        return Turno.builder()
                .id(entity.getId())
                .atacante(pokemonMapper.toDomain(entity.getAtacante()))
                .movimiento(movimientoMapper.toDomain(entity.getMovimiento()))
                .danio(entity.getDanio())
                .psRestantesRival(entity.getPsRestantesRival())
                .build();
    }


    public TurnoEntity toEntity(Turno domain, CombateEntity combate) {
        return TurnoEntity.builder()
                .id(domain.getId())
                .atacante(pokemonMapper.toEntity(domain.getAtacante()))
                .movimiento(movimientoMapper.toEntity(domain.getMovimiento()))
                .danio(domain.getDanio())
                .psRestantesRival(domain.getPsRestantesRival())
                .combate(combate)
                .build();
    }


}
