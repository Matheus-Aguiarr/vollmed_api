package com.vollmed.apirest.dtos.medico;

import com.vollmed.apirest.domain.medico.Especialidade;
import com.vollmed.apirest.domain.medico.MedicoModel;

public record MedicoResponseDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public MedicoResponseDTO(MedicoModel medicoModel) {
        this (
                medicoModel.getId(),
                medicoModel.getNome(),
                medicoModel.getEmail(),
                medicoModel.getCrm(),
                medicoModel.getEspecialidade()
        );
    }
}
