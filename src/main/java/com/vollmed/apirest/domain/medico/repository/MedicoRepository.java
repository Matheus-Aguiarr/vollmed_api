package com.vollmed.apirest.domain.medico.repository;

import com.vollmed.apirest.domain.medico.MedicoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {

//    @Query("SELECT m FROM MedicoModel m WHERE m.ativo = true")
    Page<MedicoModel> findAllByAtivoTrue(Pageable pageable);
}
