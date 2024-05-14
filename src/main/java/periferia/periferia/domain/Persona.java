package periferia.periferia.domain;

import lombok.Data;
@Data
public class Persona{

    public Persona(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono, String direccion, String ciudadResidencia, char tipoDocumento, String documento) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudadResidencia = ciudadResidencia;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
    }


    
    private String primerNombre;
    
    private String segundoNombre;
    
    private String primerApellido;
    
    private String segundoApellido;
    
    private String telefono;
    
    private String direccion;
    
    private String ciudadResidencia;

    private char tipoDocumento;
    
    private String documento;
   
    }
