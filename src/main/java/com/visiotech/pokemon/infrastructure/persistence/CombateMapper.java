package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.Combate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CombateMapper {

    private final PokemonMapper pokemonMapper;
    private final TurnoMapper turnoMapper;

    public Combate toDomain(CombateEntity entity){
        return Combate.builder()
                .id(entity.getId())
                .pokemon1(pokemonMapper.toDomain(entity.getPokemon1()))
                .pokemon2(pokemonMapper.toDomain(entity.getPokemon2()))
                .psPokemon1(entity.getPsPokemon1())
                .psPokemon2(entity.getPsPokemon2())
                .turnoDeQuien(entity.getTurnoDeQuien())
                .estado(entity.getEstado())
                .ganador(entity.getGanador() != null
                        ? pokemonMapper.toDomain(entity.getGanador())
                        : null)
                .turnos(entity.getTurnos() == null
                        ? Collections.emptyList()
                        : entity.getTurnos().stream()
                          .map(turnoMapper::toDomain)
                          .collect(Collectors.toList()))
                .build();
    }



    public CombateEntity toEntity(Combate domain){
        return CombateEntity.builder()
                 .id(domain.getId())
                .pokemon1(pokemonMapper.toEntity(domain.getPokemon1()))
                .pokemon2(pokemonMapper.toEntity(domain.getPokemon2()))
                .psPokemon1(domain.getPsPokemon1())
                .psPokemon2(domain.getPsPokemon2())
                .turnoDeQuien(domain.getTurnoDeQuien())
                .estado(domain.getEstado())
                .ganador(domain.getGanador() != null
                        ? pokemonMapper.toEntity(domain.getGanador())
                        : null)
                .build();

    }



}
