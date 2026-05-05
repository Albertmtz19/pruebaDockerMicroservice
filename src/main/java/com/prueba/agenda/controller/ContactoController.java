package com.prueba.agenda.controller;

import com.prueba.agenda.dto.Contacto;
import com.prueba.agenda.service.ContactoService;
import com.prueba.agenda.utils.PropsUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/contacto")
public class ContactoController {

    PropsUtility response = new PropsUtility();
    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public List<Contacto> listar (){
        return contactoService.listar();
    }

    @PostMapping
    public ResponseEntity<Object> crear (@RequestBody Contacto c){


        Contacto cr = contactoService.crear(c);

        LocalDateTime fecha_creacion = LocalDateTime.now();

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = fecha_creacion.format(myFormatObj);

        if (cr.getFecha_creacion().equals(formattedDate)){


            return response.generatedResponse(HttpStatus.CREATED,"Usuario creado",cr);
        }else{

            return response.generatedResponse(HttpStatus.OK,"El usuario ya existe",cr);
        }

    }


    @PostMapping("/{id}")
    public void desactivar (@PathVariable Long id)  throws Exception{
        contactoService.borrar(id);
    }

    @PostMapping("/activar/{id}")
    public void activar (@PathVariable Long id)  throws Exception{
        contactoService.activar(id);
    }




}
