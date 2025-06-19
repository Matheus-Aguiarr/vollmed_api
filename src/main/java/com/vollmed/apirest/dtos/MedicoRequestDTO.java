package com.vollmed.apirest.dtos;

import jakarta.validation.constraints.NotNull;

public record MedicoRequestDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
