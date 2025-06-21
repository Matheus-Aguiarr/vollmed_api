package com.vollmed.apirest.dtos.paciente;

import com.vollmed.apirest.dtos.endereco.EnderecoDTO;

public record PacienteRequestDTO(String nome, String telefone, EnderecoDTO endereco) {
}
