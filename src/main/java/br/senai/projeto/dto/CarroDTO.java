package br.senai.projeto.dto;

import jakarta.validation.constraints.*;

public record CarroDTO(
        Long id,
        @NotEmpty(message = "Equipe é obrigatória") String equipe,
        @NotEmpty(message = "Modelo é obrigatório") String modelo,
        String motorizacao,
        @Min(value = 1950, message = "Ano deve ser maior ou igual a 1950") Integer anoTemporada,
        @NotNull(message = "Número do piloto é obrigatório") Integer numeroPiloto,
        @NotBlank(message = "Piloto principal é obrigatório") String pilotoPrincipal
) {}