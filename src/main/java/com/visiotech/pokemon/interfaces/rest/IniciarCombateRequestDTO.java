package com.visiotech.pokemon.interfaces.rest;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IniciarCombateRequestDTO {

    @NotNull
    private Long pokemon1Id;

    @NotNull
    private Long pokemon2Id;
}
