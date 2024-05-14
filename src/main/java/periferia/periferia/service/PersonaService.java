/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package periferia.periferia.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import periferia.periferia.dao.PersonaDao;
import periferia.periferia.domain.Persona;
import periferia.periferia.domain.PersonaResponse;

@Service
public class PersonaService {

    public PersonaDao personaDao = new PersonaDao();

    public PersonaResponse consultar(String tipo, String documento) {
        Optional<Persona> persona = personaDao.buscarPorDocumento(tipo, documento);
        if (persona.isPresent()) {
            PersonaResponse PersonaR = new PersonaResponse(persona.get().getPrimerNombre(), persona.get().getSegundoNombre(), persona.get().getPrimerApellido(), persona.get().getSegundoApellido(), persona.get().getTelefono(), persona.get().getDireccion(), persona.get().getCiudadResidencia());
            return PersonaR;
        } else {
            return null;
        }

    }
}
