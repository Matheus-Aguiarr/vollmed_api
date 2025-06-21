package com.vollmed.apirest.domain.paciente.repository;

import com.vollmed.apirest.domain.paciente.PacienteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository  extends JpaRepository<PacienteModel, Long> {
    Page<PacienteModel> findAllByAtivoTrue(Pageable pageable);

}
