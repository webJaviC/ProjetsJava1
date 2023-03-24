
package gesical_g20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Disco {
    private int añoEdicion;
    private HashSet<Cancion> cancionesAlbum;
    private String título;
    private Musico musico;

    public Disco(int añoEdicion, HashSet<Cancion> cancionesAlbum, String título, Musico musico) {
        this.añoEdicion = añoEdicion;
        this.cancionesAlbum = cancionesAlbum;
        this.título = título;
        this.musico = musico;
    }

    public HashSet<Cancion> getCancionesAlbum() {
        return cancionesAlbum;
    }

    public void setCancionesAlbum(HashSet<Cancion> cancionesAlbum) {
        this.cancionesAlbum = cancionesAlbum;
    }

 

    public int getAñoEdicion() {
        return añoEdicion;
    }

    public void setAñoEdicion(int añoEdicion) {
        this.añoEdicion = añoEdicion;
    }

 

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public Musico getMusico() {
        return musico;
    }

    public void setMusico(Musico musico) {
        this.musico = musico;
    }
    
    public void printList(){
          for (Cancion d : cancionesAlbum) {
                System.out.println(d.getTitulo());         
        }
    }
    
    public void listarCanciones(){
        for ( Cancion c: cancionesAlbum){
            System.out.println(
                   "Titulo de la cancion: " + c.getTitulo() + " " +
                   "Titulo del disco: "+ this.getTítulo() + "  " +
                   "Musico: " + this.musico.toString()                              
            );
        }
    }
    
        public int obtenerTiempoDeldisco(){
            int tiempo = 0;
        for ( Cancion c: cancionesAlbum){
            tiempo = tiempo + c.getDuracion();
           }
            return tiempo;
        }
    
        public void agregarCancion(Cancion cancion){
           this.cancionesAlbum.add(cancion);
        }
    
 }
        
    
   


