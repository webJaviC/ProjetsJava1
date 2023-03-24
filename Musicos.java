
package gesical_g20;

import java.util.ArrayList;
import java.util.List;


public class Musicos {
        private List<Musico> musicos = new ArrayList<>();

        
    public List<Musico> getMusicos() {
        return musicos;
    }

    public void setMusicos(List<Musico> musicos) {
        this.musicos = musicos;
    }    
    
     public void agregarSolista(Solista solista) {
        this.musicos.add(solista);
    }
    
}
