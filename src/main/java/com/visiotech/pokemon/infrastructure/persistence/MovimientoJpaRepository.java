package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.TipoPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface MovimientoJpaRepository extends JpaRepository<MovimientoEntity, Long> {
    List<MovimientoEntity> findByTipo(TipoPokemon tipo);

    @Query("SELECT m FROM PokemonEntity p JOIN p.movimientos m WHERE p.id = :pokemonId")
    List<MovimientoEntity> findByPokemonId(@Param("pokemonId") Long pokemonId);
}
