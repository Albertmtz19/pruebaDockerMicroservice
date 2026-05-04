package com.prueba.agenda.controller;

import com.prueba.agenda.dto.Contacto;
import com.prueba.agenda.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacto")
public class ContactoController {
    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public List<Contacto> listar (){
        return contactoService.listar();
    }

    @PostMapping
    public Contacto crear (@RequestBody Contacto c){
        return contactoService.crear(c);
    }


    @PostMapping("/{id}")
    public void desactivar (@PathVariable Long id)  throws Exception{
        contactoService.borrar(id);
    }




}
