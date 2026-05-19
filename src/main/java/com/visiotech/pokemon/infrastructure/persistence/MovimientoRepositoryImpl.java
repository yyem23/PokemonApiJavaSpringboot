package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.Movimiento;
import com.visiotech.pokemon.domain.model.TipoPokemon;
import com.visiotech.pokemon.domain.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class MovimientoRepositoryImpl implements MovimientoRepository {

    private final MovimientoJpaRepository jpaRepository;
    private final MovimientoMapper mapper;

    @Override
    public Movimiento save(Movimiento movimiento){
        MovimientoEntity entity = mapper.toEntity(movimiento);
        MovimientoEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }


    @Override
    public Optional<Movimiento> findById(Long id){
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Movimiento> findAll(){
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteById(Long id){
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Movimiento> findByTipo(TipoPokemon tipo) {
        return jpaRepository.findByTipo(tipo).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Movimiento> findByPokemonId(Long pokemonId) {
        return jpaRepository.findByPokemonId(pokemonId).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }


}
