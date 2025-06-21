package com.vollmed.apirest.dtos.paciente;

import com.vollmed.apirest.domain.endereco.EnderecoModel;
import com.vollmed.apirest.domain.paciente.PacienteModel;

public record PacienteDetailDTO(Long id, String nome, String email, String telefone, String cpf, EnderecoModel endereco) {
    public PacienteDetailDTO(PacienteModel pacienteModel) {
        this(
                pacienteModel.getId(),
                pacienteModel.getNome(),
                pacienteModel.getEmail(),
                pacienteModel.getTelefone(),
                pacienteModel.getCpf(),
                pacienteModel.getEndereco()
        );
    }
}
