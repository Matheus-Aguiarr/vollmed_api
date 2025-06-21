package com.vollmed.apirest.dtos.medico;

import com.vollmed.apirest.dtos.endereco.EnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record MedicoRequestDTO(@NotNull Long id, String nome, String telefone, EnderecoDTO endereco) {
}
