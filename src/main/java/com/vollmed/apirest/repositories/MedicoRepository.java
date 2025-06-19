package com.vollmed.apirest.repositories;

import com.vollmed.apirest.model.MedicoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {

//    @Query("SELECT m FROM MedicoModel m WHERE m.ativo = true")
    Page<MedicoModel> findAllByAtivoTrue(Pageable pageable);
}
