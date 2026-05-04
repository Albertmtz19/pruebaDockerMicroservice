package com.prueba.agenda.repository;

import com.prueba.agenda.dto.Contacto;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {

    @Query("select u from CONTACTO u where u.email = ?1")
    Contacto findByEmailAddress(String email);


    @Query("UPDATE CONTACTO SET STATUS = FALSE WHERE email = ?1")
    Contacto desactivar(String email);

}
