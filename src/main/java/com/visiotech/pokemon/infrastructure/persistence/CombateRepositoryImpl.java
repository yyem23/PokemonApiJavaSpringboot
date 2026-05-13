package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.Combate;
import com.visiotech.pokemon.domain.repository.CombateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class CombateRepositoryImpl implements CombateRepository{


    private final CombateJpaRepository jpaRepository;
    private final CombateMapper mapper;


    @Override
    public Combate save(Combate combate){
        CombateEntity entity = mapper.toEntity(combate);
        CombateEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Combate> findById(Long id){
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }











}
