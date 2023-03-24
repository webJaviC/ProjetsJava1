
package gesical_g20;

import gesical_g20.Musico;
import java.time.LocalDate;


public class Solista extends Musico{
    private String apellido;
    private String nombre;
    private String nacionalidad;
    private Boolean tocaInstrumento;

    public Solista(String apellido, String nombre, String nacionalidad, Boolean tocaInstrumento, String genero, int añoInicio, String discografica) {
        super(genero, añoInicio, discografica);
        this.apellido = apellido;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.tocaInstrumento = tocaInstrumento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Boolean getTocaInstrumento() {
        return tocaInstrumento;
    }

    public void setTocaInstrumento(Boolean tocaInstrumento) {
        this.tocaInstrumento = tocaInstrumento;
    }
    
   public Boolean esSolista() {
    return  !this.tocaInstrumento ;
   }
   
   @Override
   public String toString(){
       return this.nombre + " " + this.apellido;
   }
   
  
}
