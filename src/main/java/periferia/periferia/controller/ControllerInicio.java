/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package periferia.periferia.controller;

import java.io.EOFException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import periferia.periferia.domain.Persona;
import periferia.periferia.domain.PersonaResponse;
import periferia.periferia.domain.Request;
import periferia.periferia.service.PersonaService;

@RestController
@Slf4j
@RequestMapping("/api")
public class ControllerInicio {

    final String TIPO_DOCUMENTO_PASAPORTE = "P";
    final String TIPO_DOCUMENTO_CEDULA = "C";

    @Autowired
    private PersonaService personaService;

    @GetMapping("/hello")
    public String hello() {
        return "Hola SpringBoot";
    }

    @GetMapping("/consultar")
    public ResponseEntity<Object> consultar(@RequestBody Request r) {

        if (r.getTipo() == null || r.getDocumento() == null) {

            log.info("Tipo de documento y documento son obligatorios.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de documento y documento son obligatorios.");

        } else {

            try {

                if (r.getTipo().equals(TIPO_DOCUMENTO_PASAPORTE) || r.getTipo().equals(TIPO_DOCUMENTO_CEDULA)) {

                    if (personaService.consultar(r.getTipo(), r.getDocumento()) != null) {
                        log.info("Usuario encontrado,documento: " + r.getDocumento());
                        return new ResponseEntity<>(personaService.consultar(r.getTipo(), r.getDocumento()), HttpStatus.OK);
//                
                    } else {
                        log.info("El documento no fue encontrado: " + r.getDocumento());
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El documento: " + r.getDocumento() + " no existe");
                    }
                } else {
                    log.info("El tipo de documento es erroneo: " + r.getTipo());
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de documento: " + r.getTipo() + " no valido");

                }

            }
            catch (Exception e) {

                log.info("Error al obtener persona con documento " + r.getDocumento(), e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");

            }

        }
    }

}
