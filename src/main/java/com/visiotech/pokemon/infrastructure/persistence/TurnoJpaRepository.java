package com.visiotech.pokemon.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoJpaRepository  extends JpaRepository<TurnoEntity, Long>{
}
