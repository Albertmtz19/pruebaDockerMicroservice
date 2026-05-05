package com.prueba.agenda.service;

import com.prueba.agenda.dto.CatalogoTelefono;
import com.prueba.agenda.dto.Contacto;
import com.prueba.agenda.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactoService {
    @Autowired
    private ContactoRepository contactoRepository;

    public List<Contacto> listar(){
        return contactoRepository.findAll();
    }

    public Contacto crear (Contacto t){




        String fecha_creacion = String.valueOf( LocalDateTime.now());

        t.setFecha_creacion(fecha_creacion);
        t.setStatus(true);
        return contactoRepository.save(t);
    }



    public void borrar (Long id) throws Exception {


        Optional<Contacto> optionalUser = contactoRepository.findById(id);

        if (!optionalUser.isPresent()) {
            // Manejar el error
            throw new Exception("No se encontro el usuario.");
        }else {

            Contacto ct = optionalUser.get();

            ct.setStatus(false);

            contactoRepository.save(ct);

        }





    }


}
