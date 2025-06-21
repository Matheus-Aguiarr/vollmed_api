package com.vollmed.apirest.domain.paciente;

import com.vollmed.apirest.domain.endereco.EnderecoModel;
import com.vollmed.apirest.dtos.paciente.PacienteDTO;
import com.vollmed.apirest.dtos.paciente.PacienteRequestDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class PacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private EnderecoModel endereco;

    private boolean ativo;

    public PacienteModel(PacienteDTO dto) {
        this.ativo = true;
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.cpf = dto.cpf();
        this.endereco = new EnderecoModel(dto.endereco());
    }

    public PacienteModel(String nome, String email, String telefone, String cpf, EnderecoModel endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void atualizarInformacoes(PacienteRequestDTO dto) {
        if (dto.nome() != null) {
            this.nome = dto.nome();
        }
        if (dto.telefone() != null) {
            this.telefone = dto.telefone();
        }
        if (dto.endereco() != null) {
            this.endereco.atualizarInformacoes(dto.endereco());
        }
    }

    public PacienteModel() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void inativar() {
        this.ativo = false;
    }
}
