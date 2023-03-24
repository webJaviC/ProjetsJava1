
package gesical_g20;

import gesical_g20.Instrumento;


public class Guitarra extends Instrumento {

    @Override
    public String tocar() {
        return "Tocar " + this.getClass().getSimpleName();
    }
    
}
