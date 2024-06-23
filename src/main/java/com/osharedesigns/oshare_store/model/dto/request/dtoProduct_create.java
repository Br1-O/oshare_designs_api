package com.osharedesigns.oshare_store.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record dtoProduct_create(
    @NotBlank(message = "¡Este campo no puede estar vacio!")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "¡Sólo se aceptan letras!")
    String name,
    String description,
    @NotBlank(message = "¡Este campo no puede estar vacio!")
    String links,
    @NotBlank(message = "¡Este campo no puede estar vacio!")
    @Pattern(regexp = "^[0-9,]{2,10}+$", message = "¡Sólo se aceptan caracteres numéricos y comas!")
    BigDecimal price,
    @NotBlank(message = "¡Este campo no puede estar vacio!")
    @Pattern(regexp = "^[0-9.]{1,2}+$", message = "¡Sólo se aceptan caracteres numéricos y puntos!")
    BigDecimal rating,
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "¡Sólo se aceptan letras!")
    String from_country,
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "¡Sólo se aceptan letras!")
    String material
    )
{}