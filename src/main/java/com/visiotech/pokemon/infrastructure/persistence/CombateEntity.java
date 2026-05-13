package com.visiotech.pokemon.infrastructure.persistence;

import com.visiotech.pokemon.domain.model.EstadoCombate;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "COMBATE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CombateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "combate_deq")
    @SequenceGenerator(name = "comabte_seq", sequenceName = "COMBATE_SEQ", allocationSize =1 )
    private Long id;


    @ManyToOne
    @JoinColumn(name = "pokemon1_id")
    private PokemonEntity pokemon1;

    @ManyToOne
    @JoinColumn(name = "pokemon2_id")
    private PokemonEntity pokemon2;

    private int psPokemon1;
    private int psPokemon2;
    private Long turnoDeQuien;


    @Enumerated(EnumType.STRING)
    private EstadoCombate estado;

    @ManyToOne
    @JoinColumn(name = "ganador_id")
    private PokemonEntity ganador;

    @OneToMany(mappedBy = "combate", cascade = CascadeType.ALL)
    private List<TurnoEntity> turnos;



}
