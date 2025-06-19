package com.vollmed.apirest.dtos;

import com.vollmed.apirest.enums.Especialidade;
import com.vollmed.apirest.model.EnderecoModel;
import com.vollmed.apirest.model.MedicoModel;

public record MedicoDetailDTO(Long id, String nome, String email, String crm, Especialidade especialidade, EnderecoModel endereco) {

    public MedicoDetailDTO(MedicoModel medicoModel) {
        this(
                medicoModel.getId(),
                medicoModel.getNome(),
                medicoModel.getEmail(),
                medicoModel.getCrm(),
                medicoModel.getEspecialidade(),
                medicoModel.getEndereco()
        );
    }
}
