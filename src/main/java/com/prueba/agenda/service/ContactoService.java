package com.prueba.agenda.service;

import com.prueba.agenda.dto.Contacto;
import com.prueba.agenda.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {
    @Autowired
    private ContactoRepository contactoRepository;

    public List<Contacto> listar(){
        return contactoRepository.findAll();
    }

    public Contacto crear (Contacto t){
        return contactoRepository.save(t);
    }
}
