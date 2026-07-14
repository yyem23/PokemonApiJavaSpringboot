package com.visiotech.pokemon.interfaces.rest;

import com.visiotech.pokemon.application.usecase.*;
import com.visiotech.pokemon.domain.model.Movimiento;
import com.visiotech.pokemon.domain.model.Pokemon;
import com.visiotech.pokemon.domain.repository.MovimientoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.visiotech.pokemon.domain.model.NotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/pokemons")
@RequiredArgsConstructor
public class PokemonController {

    private final GuardarPokemonUseCase guardarPokemonUseCase;
    private final ObtenerPokemonUseCase obtenerPokemonUseCase;
    private final ListarPokemonsUseCase listarPokemonsUseCase;
    private final EliminarPokemonUseCase eliminarPokemonUseCase;
    private final MovimientoRepository movimientoRepository;
    private final ObtenerPokemonsPorMovimientoUseCase obtenerPokemonsPorMovimientoUseCase;
    private final RestMapper restMapper;


    @PostMapping
    public ResponseEntity<PokemonResponseDTO> crear(@Valid @RequestBody PokemonRequestDTO dto){
        List<Movimiento> movimientos = dto.getMovimientoIds() == null
                ?Collections.emptyList()
                : dto.getMovimientoIds().stream()
                  .map(id -> movimientoRepository.findById(id)
                             .orElseThrow(() -> new NotFoundException("Movimiento no encontrado: " + id)))
                  .collect(Collectors.toList());


        Pokemon pokemon = Pokemon.builder()
                .nombre(dto.getNombre())
                .tipo(dto.getTipo())
                .nivel(dto.getNivel())
                .psActuales(dto.getPsActuales())
                .psTotales(dto.getPsTotales())
                .ataqueBase(dto.getAtaqueBase())
                .defensaBase(dto.getDefensaBase())
                .ataqueEspecialBase(dto.getAtaqueEspecialBase())
                .defensaEspecialBase(dto.getDefensaEspecialBase())
                .velocidadBase(dto.getVelocidadBase())
                .movimientos(movimientos)
                .build();


        Pokemon guardado = guardarPokemonUseCase.execute(pokemon);
        return ResponseEntity.ok(restMapper.toPokemonResponse(guardado));

    }


    @GetMapping("/{id}")
    public ResponseEntity<PokemonResponseDTO> obtener(@PathVariable Long id){
        return obtenerPokemonUseCase.execute(id)
                .map(restMapper::toPokemonResponse)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Pokemon no encontrado con id: " + id));
    }


    @GetMapping
    public ResponseEntity<List<PokemonResponseDTO>> listar() {
        List<PokemonResponseDTO> response = listarPokemonsUseCase.execute().stream()
                .map(restMapper::toPokemonResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PokemonResponseDTO> actualizar(@PathVariable Long id,
                                                         @Valid @RequestBody PokemonRequestDTO dto) {
        List<Movimiento> movimientos = dto.getMovimientoIds() == null
                ? Collections.emptyList()
                : dto.getMovimientoIds().stream()
                  .map(movId -> movimientoRepository.findById(movId)
                                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado: " + movId)))
                  .collect(Collectors.toList());

        Pokemon pokemon = Pokemon.builder()
                .id(id)
                .nombre(dto.getNombre())
                .tipo(dto.getTipo())
                .nivel(dto.getNivel())
                .psActuales(dto.getPsActuales())
                .psTotales(dto.getPsTotales())
                .ataqueBase(dto.getAtaqueBase())
                .defensaBase(dto.getDefensaBase())
                .ataqueEspecialBase(dto.getAtaqueEspecialBase())
                .defensaEspecialBase(dto.getDefensaEspecialBase())
                .velocidadBase(dto.getVelocidadBase())
                .movimientos(movimientos)
                .build();

        Pokemon actualizado = guardarPokemonUseCase.execute(pokemon);
        return ResponseEntity.ok(restMapper.toPokemonResponse(actualizado));
    }

    @GetMapping("/por-movimiento/{movimientoId}")
    public ResponseEntity<List<PokemonResponseDTO>> obtenerPorMovimiento(@PathVariable Long movimientoId){
        List<PokemonResponseDTO> response = obtenerPokemonsPorMovimientoUseCase.execute(movimientoId).stream()
                .map(restMapper::toPokemonResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> eliminar(@PathVariable Long id){
        eliminarPokemonUseCase.excute(id);
        return ResponseEntity.noContent().build();
    }
}
