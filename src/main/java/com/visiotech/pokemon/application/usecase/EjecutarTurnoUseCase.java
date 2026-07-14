package com.visiotech.pokemon.application.usecase;

import com.visiotech.pokemon.domain.model.*;
import com.visiotech.pokemon.domain.repository.CombateRepository;
import com.visiotech.pokemon.domain.repository.MovimientoRepository;
import com.visiotech.pokemon.domain.service.CombateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class EjecutarTurnoUseCase {

    private final CombateRepository combateRepository;
    private final MovimientoRepository movimientoRepository;
    private final CombateService combateService;

    public Combate execute(Long combateId, Long movimientoId) {
        Combate combate = combateRepository.findById(combateId)
                .orElseThrow(() -> new NotFoundException("Combate no encontrado"));

        if (combate.getEstado() == EstadoCombate.FINALIZADO) {
            throw new IllegalArgumentException("El combate ya ha finalizado");
        }

        Movimiento movimiento = movimientoRepository.findById(movimientoId)
                .orElseThrow(() -> new NotFoundException("Movimiento no encontrado"));

        // Determinar atacante y defensor
        boolean esTurnoPokemon1 = combate.getTurnoDeQuien().equals(combate.getPokemon1().getId());
        Pokemon atacante = esTurnoPokemon1 ? combate.getPokemon1() : combate.getPokemon2();
        Pokemon defensor = esTurnoPokemon1 ? combate.getPokemon2() : combate.getPokemon1();

        // Calcular daño
        int danio = combateService.calcularDanio(atacante, movimiento, defensor);

        // Actualizar PS del defensor
        int psDefensorActuales = esTurnoPokemon1 ? combate.getPsPokemon2() : combate.getPsPokemon1();
        int psDefensorNuevos = Math.max(0, psDefensorActuales - danio);

        // Crear turno
        Turno turno = Turno.builder()
                .atacante(atacante)
                .movimiento(movimiento)
                .danio(danio)
                .psRestantesRival(psDefensorNuevos)
                .build();

        // Determinar si el combate ha terminado
        EstadoCombate nuevoEstado = psDefensorNuevos == 0
                ? EstadoCombate.FINALIZADO
                : EstadoCombate.EN_CURSO;

        Pokemon ganador = psDefensorNuevos == 0 ? atacante : null;

        // Cambiar turno
        Long siguienteTurno = esTurnoPokemon1
                ? combate.getPokemon2().getId()
                : combate.getPokemon1().getId();

        // Construir nuevo estado del combate
        ArrayList<Turno> turnos = new ArrayList<>(combate.getTurnos());
        turnos.add(turno);

        Combate combateActualizado = Combate.builder()
                .id(combate.getId())
                .pokemon1(combate.getPokemon1())
                .pokemon2(combate.getPokemon2())
                .psPokemon1(esTurnoPokemon1 ? combate.getPsPokemon1() : psDefensorNuevos)
                .psPokemon2(esTurnoPokemon1 ? psDefensorNuevos : combate.getPsPokemon2())
                .turnoDeQuien(siguienteTurno)
                .estado(nuevoEstado)
                .ganador(ganador)
                .turnos(turnos)
                .build();

        return combateRepository.save(combateActualizado);
    }
}