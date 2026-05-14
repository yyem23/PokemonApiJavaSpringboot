package com.visiotech.pokemon.interfaces.rest;

import com.visiotech.pokemon.application.usecase.EjecutarTurnoUseCase;
import com.visiotech.pokemon.application.usecase.IniciarCombateUseCase;
import com.visiotech.pokemon.application.usecase.ObtenerCombateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/combates")
@RequiredArgsConstructor
public class CombateController {

    private final IniciarCombateUseCase iniciarCombateUseCase;
    private final EjecutarTurnoUseCase ejecutarTurnoUseCase;
    private final ObtenerCombateUseCase obtenerCombateUseCase;
    private final RestMapper restMapper;


    @PostMapping
    public ResponseEntity<CombateResponseDTO> iniciar(@Valid @RequestBody IniciarCombateRequestDTO dto) {
        var combate = iniciarCombateUseCase.execute(dto.getPokemon1Id(), dto.getPokemon2Id());
        return ResponseEntity.ok(restMapper.toCombateResponse(combate));
    }

    @PostMapping("/{id}/turno")
    public ResponseEntity<CombateResponseDTO> ejecutarTurno(@PathVariable Long id,
                                                            @Valid @RequestBody EjecutarTurnoRequestDTO dto) {
        var combate = ejecutarTurnoUseCase.execute(id, dto.getMovimientoId());
        return ResponseEntity.ok(restMapper.toCombateResponse(combate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CombateResponseDTO> obtener(@PathVariable Long id) {
        return obtenerCombateUseCase.execute(id)
                .map(restMapper::toCombateResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }





}
