package com.vollmed.apirest.dtos.paciente;

import com.vollmed.apirest.domain.paciente.PacienteModel;

public record PacienteResponseDTO(Long id, String nome, String email, String cpf) {

    public PacienteResponseDTO(PacienteModel pacienteModel) {
        this(
                pacienteModel.getId(),
                pacienteModel.getNome(),
                pacienteModel.getEmail(),
                pacienteModel.getCpf()
        );
    }
}
