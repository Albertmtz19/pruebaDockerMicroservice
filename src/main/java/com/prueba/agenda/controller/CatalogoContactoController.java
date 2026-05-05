package com.prueba.agenda.controller;

import com.prueba.agenda.dto.CatalogoTelefono;
import com.prueba.agenda.service.CatalogoContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo_contactos")
public class CatalogoContactoController {
    @Autowired
    private CatalogoContactoService serviceCatalogo;

    @GetMapping
    public List<CatalogoTelefono> listar (){
     return serviceCatalogo.listarCatalogo();
    }

    @PostMapping
    public CatalogoTelefono crear(@RequestBody CatalogoTelefono ct){

        return serviceCatalogo.crearCatalogo(ct);

    }

    @PutMapping("/{id}")
    public CatalogoTelefono actualizar (@PathVariable Long id,@RequestBody CatalogoTelefono ct) throws Exception {

        return  serviceCatalogo.actualizaCatalogo(id,ct);

    }


}
