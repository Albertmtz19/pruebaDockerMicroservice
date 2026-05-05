package com.prueba.agenda.controller;

import com.prueba.agenda.dto.CatalogoTelefono;
import com.prueba.agenda.service.CatalogoContactoService;
import com.prueba.agenda.utils.PropsUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo_contactos")
public class CatalogoContactoController {
    public PropsUtility response = new PropsUtility();

    @Autowired
    private CatalogoContactoService serviceCatalogo;

    @GetMapping
    public ResponseEntity<Object> listar (){
        return response.generatedResponse(HttpStatus.OK,"Contactos",serviceCatalogo.listarCatalogo());
    }

    @PostMapping
    public ResponseEntity<Object> crear(@RequestBody CatalogoTelefono ct){

        return response.generatedResponse(HttpStatus.OK,"Medio de contacto creado",serviceCatalogo.crearCatalogo(ct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object>  actualizar (@PathVariable Long id,@RequestBody CatalogoTelefono ct) throws Exception {
        return response.generatedResponse(HttpStatus.OK,"Medio de contacto actualizadp",serviceCatalogo.actualizaCatalogo(id,ct));
    }


}
