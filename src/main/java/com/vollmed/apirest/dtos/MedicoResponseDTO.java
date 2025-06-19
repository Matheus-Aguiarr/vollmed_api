package com.vollmed.apirest.dtos;

import com.vollmed.apirest.enums.Especialidade;
import com.vollmed.apirest.model.MedicoModel;

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
