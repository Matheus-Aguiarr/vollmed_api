package com.vollmed.apirest.controllers;

import com.vollmed.apirest.dtos.paciente.PacienteDTO;
import com.vollmed.apirest.dtos.paciente.PacienteDetailDTO;
import com.vollmed.apirest.dtos.paciente.PacienteRequestDTO;
import com.vollmed.apirest.dtos.paciente.PacienteResponseDTO;
import com.vollmed.apirest.domain.paciente.PacienteModel;
import com.vollmed.apirest.domain.paciente.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping()
    public ResponseEntity<PacienteDetailDTO> cadastrarPaciente(@RequestBody @Valid PacienteDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        var paciente = pacienteRepository.save(new PacienteModel(dto));

        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new PacienteDetailDTO(paciente));
    }

    @GetMapping()
    public ResponseEntity<Page<PacienteResponseDTO>> listarPacientes(Pageable pageable) {
        var page = pacienteRepository.findAllByAtivoTrue(pageable).map(PacienteResponseDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDetailDTO> getPacienteById(@PathVariable Long id) {
        PacienteModel searchPaciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente not found."));
        return ResponseEntity.ok(new PacienteDetailDTO(searchPaciente));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteDetailDTO> atualizarPaciente(@PathVariable Long id, @RequestBody PacienteRequestDTO dto) {
        PacienteModel searchPaciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente not found."));
        searchPaciente.atualizarInformacoes(dto);
        return ResponseEntity.ok(new PacienteDetailDTO(searchPaciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPaciente(@PathVariable Long id) {
        PacienteModel searchPaciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente not found."));
        searchPaciente.inativar();
        return ResponseEntity.noContent().build();
    }


}
