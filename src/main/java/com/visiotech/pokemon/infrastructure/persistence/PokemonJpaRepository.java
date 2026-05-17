package com.visiotech.pokemon.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PokemonJpaRepository extends JpaRepository<PokemonEntity, Long>{
    List<PokemonEntity> findByMovimientos_Id(Long movimientoId);
}
