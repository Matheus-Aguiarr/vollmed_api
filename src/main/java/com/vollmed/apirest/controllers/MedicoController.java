package com.vollmed.apirest.controllers;

import com.vollmed.apirest.dtos.MedicoDTO;
import com.vollmed.apirest.dtos.MedicoDetailDTO;
import com.vollmed.apirest.dtos.MedicoRequestDTO;
import com.vollmed.apirest.dtos.MedicoResponseDTO;
import com.vollmed.apirest.model.MedicoModel;
import com.vollmed.apirest.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping()
    public ResponseEntity cadastrarMedico(@RequestBody @Valid MedicoDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        var medico = new MedicoModel(dto);
        medicoRepository.save(medico);

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicoDetailDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoResponseDTO>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = medicoRepository.findAllByAtivoTrue(pageable)
                        .map(MedicoResponseDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDetailDTO> getMedicoById(@PathVariable Long id) {
        MedicoModel searchMedico = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("MedicoNotFound."));
        return ResponseEntity.ok(new MedicoDetailDTO(searchMedico));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<MedicoDetailDTO> atualizarMedico(@RequestBody @Valid MedicoRequestDTO dto) {
        MedicoModel searchMedico = medicoRepository.getReferenceById(dto.id());
        searchMedico.atualizarInformacoes(dto);
        return ResponseEntity.ok(new MedicoDetailDTO(searchMedico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarMedico(@PathVariable Long id) {
        MedicoModel searchMedico = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medico not found."));
        searchMedico.inativar();
        return ResponseEntity.noContent().build();
    }

}
