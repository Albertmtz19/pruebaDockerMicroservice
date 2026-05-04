package com.prueba.agenda.service;

import com.prueba.agenda.dto.CatalogoTelefono;
import com.prueba.agenda.repository.CatalogoContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoContactoService {

    @Autowired
    private  CatalogoContactoRepository repo;

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

        CatalogoTelefono ct = new CatalogoTelefono();

        ct.setTipo(t.getTipo());

        repo.save(ct);


        return ct ;
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
