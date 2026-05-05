package com.prueba.agenda.repository;

import com.prueba.agenda.dto.Contacto;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

    /*
    @Query("select u from CONTACTO u where u.email = ?1")
    Contacto findByEmailAddress(String email);
*/
/*
    @Modifying
    @Transactional
    @Query("UPDATE CONTACTO c SET c.STATUS = 0 WHERE c.email = :email")
    void deactivateContactByEmail(@Param("email") String email);*/
    //UPDATE CONTACTO c SET c.STATUS = 0 WHERE c.email = 'jose@example.com';
    //select id,nombre,status,email From contacto where email = 'jose@example.com';

}
