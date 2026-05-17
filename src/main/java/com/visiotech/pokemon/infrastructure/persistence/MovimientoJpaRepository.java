package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.TipoPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoJpaRepository extends JpaRepository<MovimientoEntity, Long> {
    List<MovimientoEntity> findByTipo(TipoPokemon tipo);
    List<MovimientoEntity> findByPokemon_Id(Long pokemonId);
}
