
package gesical_g20;



public class Cancion {
    private String titulo;
    private int duracion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    /*
      public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    */
    public Cancion(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }
    
  @Override
    public boolean equals(Object obj) {
        // hay que asegurar que obj es de la clase Cliente
        if (obj != null && obj instanceof Cancion) {
            // se comparan los números de identificación
            Cancion another = (Cancion) obj;
            return (this.titulo.equals(another.titulo) && this.duracion == another.duracion);
        } else {
            return false;
        }
    }
    // Identificador único del objeto para colecciones HashSet, por ejemplo
    @Override
    public int hashCode() {
        // Se utilizará el número de identificación.
        return this.duracion*1000;
    }
    
}
