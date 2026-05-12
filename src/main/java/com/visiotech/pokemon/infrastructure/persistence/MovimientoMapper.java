package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.Movimiento;
import org.springframework.stereotype.Component;


@Component
public class MovimientoMapper {


    public Movimiento toDomain(MovimientoEntity entity){
        return Movimiento.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .poder(entity.getPoder())
                .tipo(entity.getTipo())
                .build();
    }


    public MovimientoEntity toEntity(Movimiento domain){
        return MovimientoEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .poder(domain.getPoder())
                .tipo(domain.getTipo())
                .build();

    }

}
