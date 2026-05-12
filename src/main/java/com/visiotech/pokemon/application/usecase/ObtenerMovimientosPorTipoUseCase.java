package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.Movimiento;
import com.visiotech.pokemon.domain.model.TipoPokemon;
import com.visiotech.pokemon.domain.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObtenerMovimientosPorTipoUseCase {

    private final MovimientoRepository movimientoRepository;

    public List<Movimiento> execute(TipoPokemon tipo){
        return movimientoRepository.findByTipo(tipo);
    }
}
