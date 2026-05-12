package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.TipoPokemon;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;



@Entity
@Table(name = "POKEMON")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokemon_seq")
    @SequenceGenerator(name ="pokemon_seq", sequenceName = "POKEMON_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPokemon tipo;

    @Column(nullable = false)
    private int nivel;

    private int psActuales;
    private int psTotales;
    private int ataqueBase;
    private int defensaBase;
    private int ataqueEspecialBase;
    private int defensaEspecialBase;
    private int velocidadBase;



    @ManyToMany
    @JoinTable(
            name = "POKEMON_MOVIMIENTO",
            joinColumns = @JoinColumn(name ="pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "movimiento_id")
    )
    private List<MovimientoEntity> movimientos;


}
