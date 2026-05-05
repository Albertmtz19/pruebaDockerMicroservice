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

    public PropsUtility response = new PropsUtility();
    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public ResponseEntity<Object> listar (){

        return response.generatedResponse(HttpStatus.OK,"Lista de usuarios",contactoService.listar());
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

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizar (@PathVariable Long id, @RequestBody Contacto c){


        Contacto cr = contactoService.actualizar(id,c);


            return response.generatedResponse(HttpStatus.OK,"Contacto actualizado",cr);


    }


    @PostMapping("/{id}")
    public ResponseEntity<Object> desactivar (@PathVariable Long id)  throws Exception{
        contactoService.borrar(id);
        return response.generatedResponse(HttpStatus.OK,"Contacto Desactivado",contactoService.borrar(id));
    }

    @PostMapping("/activar/{id}")
    public ResponseEntity<Object> activar (@PathVariable Long id)  throws Exception{

        return response.generatedResponse(HttpStatus.OK,"Contacto Reactivado",contactoService.activar(id));
    }

    @PostMapping("/buscar/{id}")
    public ResponseEntity<Object> buscar (@PathVariable Long id)  throws Exception{
        return  response.generatedResponse(HttpStatus.FOUND,"Contacto Encontrado",contactoService.buscarxId(id));
    }
}
