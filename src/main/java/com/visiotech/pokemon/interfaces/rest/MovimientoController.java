package com.visiotech.pokemon.interfaces.rest;

import com.visiotech.pokemon.application.usecase.GuardarMovimientoUseCase;
import com.visiotech.pokemon.application.usecase.ObtenerMovimientosPorTipoUseCase;
import com.visiotech.pokemon.domain.model.Movimiento;
import com.visiotech.pokemon.domain.model.TipoPokemon;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovimientoController {

    private final GuardarMovimientoUseCase guardarMovimientoUseCase;
    private final ObtenerMovimientosPorTipoUseCase obtenerMovimientosPorTipoUseCase;
    private final RestMapper restMapper;


    @PostMapping
    public ResponseEntity<MovimientoResponseDTO> crear(@Valid @RequestBody MovimientoRequestDTO dto){
        var movimiento = restMapper.toMovimientoDomain(dto);
        var guardado = guardarMovimientoUseCase.execute(movimiento);
        return ResponseEntity.ok(restMapper.toMovimientoResponse(guardado));
    }


    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<MovimientoResponseDTO>> obtenerPorTipo(@PathVariable TipoPokemon tipo ){
        var movimientos = obtenerMovimientosPorTipoUseCase.execute(tipo);
        var response = movimientos.stream()
                .map(restMapper::toMovimientoResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }






}
