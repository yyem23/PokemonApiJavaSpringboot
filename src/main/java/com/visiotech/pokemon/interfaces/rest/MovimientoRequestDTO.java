package com.visiotech.pokemon.interfaces.rest;

import com.visiotech.pokemon.domain.model.TipoPokemon;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MovimientoRequestDTO {

    @NotBlank
    private String nombre;

    @Min(1)
    private int poder;

    @NotNull
    private TipoPokemon tipo;
}
