package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.Pokemon;
import com.visiotech.pokemon.domain.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PokemonRepositoryImpl implements PokemonRepository {

    private final PokemonJpaRepository jpaRepository;
    private final PokemonMapper mapper;

    @Override
    public Pokemon save(Pokemon pokemon) {
        PokemonEntity entity = mapper.toEntity(pokemon);
        PokemonEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Pokemon> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Pokemon> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}