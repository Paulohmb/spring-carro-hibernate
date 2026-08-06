package br.senai.projeto.dto;

import jakarta.validation.constraints.*;

public record CarroDTO(
        @NotEmpty(message = "Equipe é obrigatória") String equipe,
        @NotEmpty(message = "Modelo é obrigatório") String modelo,
        String motorizacao,
        @Min(1950) Integer anoTemporada,
        @NotNull Integer numeroPiloto,
        @NotBlank String pilotoPrincipal
) {}
