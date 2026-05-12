package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.TipoPokemon;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "MOVIMIENTO")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimiento_seq")
    @SequenceGenerator(name = "movimiento_seq", sequenceName = "MOVIMIENTO_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int poder;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPokemon tipo;


}
