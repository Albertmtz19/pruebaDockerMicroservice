package com.prueba.agenda.repository;

import com.prueba.agenda.dto.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
