package com.visiotech.pokemon.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TurnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_seq")
    @SequenceGenerator(name = "turno_seq", sequenceName = "TURNO_SEQ", allocationSize = 1)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "atacante_id")
    private PokemonEntity atacante;

    @ManyToOne
    @JoinColumn(name = "movimiento_id")
    private MovimientoEntity movimiento;

    private int danio;
    private int psRestantesRival;

    @ManyToOne
    @JoinColumn(name = "combate_id")
    private CombateEntity combate;





}
