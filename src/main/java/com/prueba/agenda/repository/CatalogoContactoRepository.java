package com.prueba.agenda.repository;

import com.prueba.agenda.dto.CatalogoTelefono;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoContactoRepository extends JpaRepository <CatalogoTelefono,Long>{
}
