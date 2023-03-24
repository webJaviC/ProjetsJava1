
package gesical_g20;

import java.time.LocalDate;


public abstract class Musico {
    private String genero;
    private int añoInicio;
    private String discografica;

    public Musico(String genero, int añoInicio, String discografica) {
        this.genero = genero;
        this.añoInicio = añoInicio;
        this.discografica = discografica;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAñoInicio() {
        return añoInicio;
    }

    public void setAñoInicio(int añoInicio) {
        this.añoInicio = añoInicio;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }
    
     
   
    
}
