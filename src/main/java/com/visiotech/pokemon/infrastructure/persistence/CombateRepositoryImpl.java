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
    private final TurnoJpaRepository turnoJpaRepository;
    private final CombateMapper mapper;
    private final TurnoMapper turnoMapper;


    @Override
    public Combate save(Combate combate){
        CombateEntity entity = mapper.toEntity(combate);
        CombateEntity saved = jpaRepository.save(entity);

        if(combate.getTurnos() != null && !combate.getTurnos().isEmpty()){
            System.out.println("Guardando " + combate.getTurnos().size() + " turnos");
            combate.getTurnos().forEach(turno -> {
                TurnoEntity turnoEntity = turnoMapper.toEntity(turno, saved);
                System.out.println("Turno entity: " + turnoEntity);
                turnoJpaRepository.save(turnoEntity);
            });
        }

        return mapper.toDomain(jpaRepository.findById(saved.getId()).orElseThrow());
    }

    @Override
    public Optional<Combate> findById(Long id){
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

}
