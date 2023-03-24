
package gesical_g20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class SistemaDeGestion {
    
    private List<Musico> musicos = new ArrayList<>();
    private List<Cancion> canciones = new ArrayList<>();
    private List<Disco> discos = new ArrayList<>();

    public List<Musico> getMusicos() {
        return musicos;
    }

    public void setMusicos(List<Musico> musicos) {
        this.musicos = musicos;
    }    
    
     public void agregarMusico(Musico musico) {
        this.musicos.add(musico);
    }
     
    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }    
    
     public void agregarCancion(Cancion cancion) {
        this.canciones.add(cancion);
    }
     
       public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }    
    
     public void agregarDisco(Disco disco) {
        this.discos.add(disco);
    }
     
       
    public void obtenerDiscosPorGenero (String generoElegidoUsuario){
        for (Disco d : discos){
            if(d.getMusico().getGenero().equals(generoElegidoUsuario)){
                d.listarCanciones();
            } 
        }
    }
    
     
    public void listarDiscosPorMusico (){
     Iterator iterator = musicos.iterator();
     while(iterator.hasNext()){
        System.out.println(iterator.next().toString());
     }     
    }
    
    public void listarMusicos (){
     int tamaño = musicos.size();
     for (int i = 0 ; i<tamaño ; i++ ){
       System.out.println(i + ": " + musicos.get(i).toString());
     }
    }
    
      public Musico obtenerMusicoPorIndex (int index){
       return musicos.get(index);   
    }
      
      public void obtenerDiscoPorMusico(Musico musico){
        for (Disco d : discos) {
            if(d.getMusico().equals(musico)){
                System.out.println(d.getTítulo() + d.getAñoEdicion());
            }
        }
      }
      
       public void listarDiscos(){
          for (Disco d : discos) {
                System.out.println(d.getTítulo());         
        }
    }
       
        public void borrarDiscosSegunAño(int año){
            int contador = 0;
        for (Disco d : discos) {
            if((d.getAñoEdicion() <= año)){
                discos.remove(d);
                contador++;
            }
            }
        if(contador == 0){
                System.out.println("Introduzca un año de edicion valido");
            }
      }

          public void listarDiscosPorTiempo(int duracion){
               int contador = 0;
               for (Disco d : discos) {
                  if((d.obtenerTiempoDeldisco() > duracion)){
                  System.out.println(
                  d.getTítulo() + " -- " + d.getMusico() 
               );
                contador ++;
                 }    
           }
            if (contador == 0){
              System.out.println("No se encontraron discos que duren más que " + duracion + " segundos");
             }     
       }
          public Disco obtenerDiscosPorIndex (int index){
       return discos.get(index);   
    }
   }
         