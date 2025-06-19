package com.vollmed.apirest.dtos;

import com.vollmed.apirest.model.EnderecoModel;
import com.vollmed.apirest.model.PacienteModel;

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
