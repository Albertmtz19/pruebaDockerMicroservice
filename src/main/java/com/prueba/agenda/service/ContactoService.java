package com.prueba.agenda.service;

import com.prueba.agenda.dto.CatalogoTelefono;
import com.prueba.agenda.dto.Contacto;
import com.prueba.agenda.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        try {
            Contacto c = contactoRepository.findByEmail(t.getEmail());


            if(c.getEmail() == null) {

                String fecha_creacion = String.valueOf(LocalDateTime.now());

                t.setFecha_creacion(fecha_creacion);
                t.setStatus(true);
                return contactoRepository.save(t);
            }else{
                return c;
            }
        }catch (Exception e){
            LocalDateTime fecha_creacion = LocalDateTime.now();

            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = fecha_creacion.format(myFormatObj);

            t.setFecha_creacion(formattedDate);
            t.setStatus(true);
            contactoRepository.save(t);



            return contactoRepository.save(t);

        }

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

    public void activar (Long id) throws Exception {
        Optional<Contacto> optionalUser = contactoRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new Exception("No se encontro el usuario.");
        }else {

            Contacto ct = optionalUser.get();

            ct.setStatus(true);

            contactoRepository.save(ct);

        }
    }

    public Contacto buscarxId (Long id) throws Exception {
        Optional<Contacto> optionalContacto = contactoRepository.findById(id);

        if (optionalContacto.isPresent()){
            throw new Exception("No se encontro contacto");
        }else {
        return optionalContacto.get();
        }
    }


    public Contacto actualizar(Long id, Contacto c){

        LocalDateTime fecha_creacion = LocalDateTime.now();

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = fecha_creacion.format(myFormatObj);

        Optional<Contacto> contactoRecuperado = contactoRepository.findById(id);

        contactoRecuperado.get().setNombre(c.getNombre());
        contactoRecuperado.get().setApellido(c.getApellido());
        contactoRecuperado.get().setEmail(c.getEmail());
        contactoRecuperado.get().setStatus(c.isStatus());
        contactoRecuperado.get().setFecha_actualizacion(formattedDate);



        return contactoRepository.save(contactoRecuperado.get());
    }


}
