
package gesical_g20;

import gesical_g20.Musico;
import java.time.LocalDate;
import java.util.List;


public class Banda extends Musico{
   private String nombreBanda;
   private List<Solista> listaMusicos;

    public Banda(String nombreBanda, List<Solista> listaMusicos, String genero, int añoInicio, String discografica) {
        super(genero, añoInicio, discografica);
        this.nombreBanda = nombreBanda;
        this.listaMusicos = listaMusicos;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public List<Solista> getListaMusicos() {
        return listaMusicos;
    }

    public void setListaMusicos(List<Solista> listaMusicos) {
        this.listaMusicos = listaMusicos;
    }
    
   @Override
   public String toString(){
       return this.nombreBanda;
   }
   

       
}
