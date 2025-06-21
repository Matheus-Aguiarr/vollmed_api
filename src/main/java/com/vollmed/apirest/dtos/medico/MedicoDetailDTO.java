package com.vollmed.apirest.dtos.medico;

import com.vollmed.apirest.domain.medico.Especialidade;
import com.vollmed.apirest.domain.endereco.EnderecoModel;
import com.vollmed.apirest.domain.medico.MedicoModel;

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
