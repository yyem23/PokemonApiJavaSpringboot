package com.visiotech.pokemon.domain.model;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String mensaje){
        super(mensaje);
    }
}
