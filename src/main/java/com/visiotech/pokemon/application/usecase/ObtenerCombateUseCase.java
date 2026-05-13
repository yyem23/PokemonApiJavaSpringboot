package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.Combate;
import com.visiotech.pokemon.domain.repository.CombateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObtenerCombateUseCase {

    private final CombateRepository combateRepository;

    public Optional<Combate> execute(Long id){
        return combateRepository.findById(id);
    }
}
