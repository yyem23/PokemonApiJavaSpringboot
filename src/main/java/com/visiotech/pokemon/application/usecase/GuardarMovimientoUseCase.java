package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.Movimiento;
import com.visiotech.pokemon.domain.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuardarMovimientoUseCase {

    private final MovimientoRepository movimientoRepository;

    public Movimiento execute(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }
}
