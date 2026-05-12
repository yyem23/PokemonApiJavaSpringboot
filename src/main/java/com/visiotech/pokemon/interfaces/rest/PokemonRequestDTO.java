package com.visiotech.pokemon.interfaces.rest;

import com.visiotech.pokemon.domain.model.TipoPokemon;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class PokemonRequestDTO {

    @NotBlank
    private String nombre;

    @NotNull
    private TipoPokemon tipo;

    @Min(1) @Max(100)
    private int nivel;

    @Min(1)
    private int psActuales;

    @Min(1)
    private int psTotales;

    @Min(1)
    private int ataqueBase;

    @Min(1)
    private int defensaBase;

    @Min(1)
    private int ataqueEspecialBase;

    @Min(1)
    private int defensaEspecialBase;

    @Min(1)
    private int velocidadBase;

    @Size(max = 4)
    private List<Long> movimientoIds;


}
