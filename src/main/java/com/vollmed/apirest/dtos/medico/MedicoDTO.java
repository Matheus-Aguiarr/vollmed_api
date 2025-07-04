package com.vollmed.apirest.dtos.medico;

import com.vollmed.apirest.domain.medico.Especialidade;
import com.vollmed.apirest.dtos.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoDTO(@NotBlank
                        String nome,
                        @NotBlank
                        @Email
                        String email,
                        @NotBlank
                        String telefone,
                        @NotBlank
                        @Pattern(regexp = "\\d{4,6}")
                        String crm,
                        @NotNull
                        Especialidade especialidade,
                        @NotNull
                        @Valid
                        EnderecoDTO endereco) {


}
