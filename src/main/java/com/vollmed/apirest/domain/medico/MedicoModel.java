package com.vollmed.apirest.domain.medico;

import com.vollmed.apirest.domain.endereco.EnderecoModel;
import com.vollmed.apirest.dtos.medico.MedicoDTO;
import com.vollmed.apirest.dtos.medico.MedicoRequestDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "medicos")
public class MedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private EnderecoModel endereco;

    private boolean ativo;

    public MedicoModel(MedicoDTO dto) {
        this.ativo = true;
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.crm = dto.crm();
        this.especialidade = dto.especialidade();
        this.endereco = new EnderecoModel(dto.endereco());
    }

    public MedicoModel(String nome, String email,String telefone,  String crm, Especialidade especialidade, EnderecoModel endereco) {
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public MedicoModel() {
    }

    public void inativar() {
        this.ativo = false;
    }

    public void atualizarInformacoes(MedicoRequestDTO dto) {
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

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

}
