package com.prueba.agenda.service;

import com.prueba.agenda.dto.CatalogoTelefono;
import com.prueba.agenda.dto.Contacto;
import com.prueba.agenda.repository.CatalogoContactoRepository;
import com.prueba.agenda.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogoContactoService {

    @Autowired
    private  CatalogoContactoRepository repo;
    @Autowired
    private ContactoRepository contactoRepository;

    public List<CatalogoTelefono> listarCatalogo (){ return repo.findAll();}
    public CatalogoTelefono crearCatalogo (CatalogoTelefono t){ return repo.save(t);}

    public CatalogoTelefono buscarxId (Long id) throws Exception {
        Optional<CatalogoTelefono> optionalUser = repo.findById(id);

        if (!optionalUser.isPresent()) {
            // Manejar el error
            throw new Exception("No se encontro el usuario.");
        }

        CatalogoTelefono ct = new CatalogoTelefono();

        return ct = optionalUser.get();

    }
    public CatalogoTelefono actualizaCatalogo (Long id, CatalogoTelefono t) throws Exception {

        Optional<CatalogoTelefono> optionalUser = repo.findById(id);

        if (!optionalUser.isPresent()) {
            // Manejar el error
            throw new Exception("No se encontro el usuario.");
        }

        Contacto contactoRelacionado = contactoRepository.findById(optionalUser.get().getContacto().getId()).get();

        optionalUser.get().setTipo(t.getTipo());
        optionalUser.get().setDescripcion(t.getDescripcion());
        optionalUser.get().setContacto(contactoRelacionado);

        CatalogoTelefono ct = new CatalogoTelefono();

        ct.setTipo(t.getTipo());
        ct.setDescripcion(t.getDescripcion());
        ct.setContacto(contactoRelacionado);


        return repo.save(optionalUser.get()) ;
        }

        public void eliminar (Long id) throws Exception {

            Optional<CatalogoTelefono> optionalUser = repo.findById(id);

            if (!optionalUser.isPresent()) {
                // Manejar el error
                throw new Exception("No se encontro el usuario.");
            }

            CatalogoTelefono ct = new CatalogoTelefono();

        }
}
