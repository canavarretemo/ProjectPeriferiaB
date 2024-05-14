/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package periferia.periferia.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import periferia.periferia.domain.Persona;


public class PersonaDao {

    public List<Persona> personas = new ArrayList<>();

    public void guardarPersonas() {

        Persona person1 = new Persona("Carlos", "Andres", "Navarrete", "Morales", "+57312587459", "Calle 58 sur # 58 - 85", "Bogotá", 'C', "1023546987");
        Persona person2 = new Persona("Juan", "Camilo", "Benavides", "Trillos", "+57517586125", "Calle 85 # 20 - 89", "Une", 'C', "58789654");
        Persona person3 = new Persona("Camila", "Andrea", "Zorro", "Cifuentes", "+57555482178", "Calle 13 # 78 - 20", "Medellín", 'P', "112536458");
        Persona person4 = new Persona("Ursula", "Sofia", "Rojas", "Betancourt", "+5757887458", "Calle 120 # 80 - 85", "Cali", 'P', "58978456");

        personas.add(person1);
        personas.add(person2);
        personas.add(person3);
        personas.add(person4);
 
    }
    
    public  Optional<Persona> buscarPorDocumento(String tipo, String documento){
        guardarPersonas();        
        return personas.stream().filter(persona -> persona.getDocumento().equals(documento)).findFirst();
        
    }

}