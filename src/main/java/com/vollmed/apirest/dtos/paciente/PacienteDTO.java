package com.vollmed.apirest.dtos.paciente;

import com.vollmed.apirest.dtos.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteDTO(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String telefone, @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpf, @NotNull @Valid EnderecoDTO endereco) {
}
