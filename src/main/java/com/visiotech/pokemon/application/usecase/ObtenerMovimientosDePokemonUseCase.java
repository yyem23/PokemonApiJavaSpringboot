package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.Movimiento;
import com.visiotech.pokemon.domain.repository.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ObtenerMovimientosDePokemonUseCase {

    private final MovimientoRepository movimientoRepository;

    public List<Movimiento> execute(Long pokemonId){
        return movimientoRepository.findByPokemonId(pokemonId);
    }
}
