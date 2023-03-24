
package gesical_g20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Gesical_g20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     SistemaDeGestion colecciones = new SistemaDeGestion();
     
      Solista solista = new Solista("Esposito", "Lalo", "argentina", true, "Cumbia", 2010, "Records");
       colecciones.agregarMusico(solista);
      Solista solista2 = new Solista("Soledad", "Pastoruti", "argentina", true, "Pop", 2015, "Records");
       colecciones.agregarMusico(solista2);

      Scanner entrada = new Scanner(System.in);
        String ingreso = "";
      
              while (!ingreso.equals("9")){
         mostrarMenuPrincipal();
         ingreso = entrada.nextLine() ;
         switch (ingreso){
             case "1" : registrarSolista(colecciones) ;
             break;
             case "2" : registrarBanda(colecciones) ;
             break;
             case "3" : registrarCancion(colecciones);
             break;
             case "4" : registrarDisco(colecciones);
             break;
             case "5" : registroMasivo(colecciones);
             break;
             case "6" : mostrarConsultas();
               String in = entrada.nextLine() ;
               consultar(in, colecciones);
             break;
             case "9" : System.out.println("Programa finalizado");
             break;
             default: System.out.println("Ingrese un numero válido");
             break;               
         }  
      
      }   
    }
    
       private static void mostrarMenuPrincipal(){ 
        System.out.println("     GESICAL - Sistema de Gestión Musical   ");
        System.out.println("         Menu Principal");
        System.out.println("===============================");
        System.out.println("1.- Registrar Solista");
        System.out.println("2.- Registrar Banda");
        System.out.println("3.- Registrar Cancion");
        System.out.println("4.- Registrar Disco");
        System.out.println("5.- Registro Masivo - Datos de Prueba");
        System.out.println("6.- Consultas");
        System.out.println(" ");
        System.out.println("9.- Cerrar la aplicación");    
        System.out.println("Ingrese una opción");    

    }
    
  private static Solista registrarSolista( SistemaDeGestion colecciones) {
    Scanner entradaSolista = new Scanner(System.in);
    String nombre ;  
    String apellido;
    String nacionalidad ;
    Boolean tocaInstrumento;
    String genero;
    int añoInicio;
    String discografica;
     
     System.out.println("A continuación te pediremos los datos del solista");
          System.out.println("Nombre:");
          nombre = entradaSolista.nextLine();
         System.out.println("Apellido:");
         apellido = entradaSolista.nextLine();
         System.out.println("Nacionalidad:");
          nacionalidad = entradaSolista.nextLine();
         System.out.println("Indique si toca algún instrumento:");
          String toca = entradaSolista.nextLine();
          tocaInstrumento = toca.equals("si") || toca.equals("SI") || toca.equals("Si");
          System.out.println("Genero musical:");
         genero = entradaSolista.nextLine();       
          System.out.println("Discografica a la que pertenece:");
         discografica = entradaSolista.nextLine();
          System.out.println("Año de inicio de su carrera musical:");
         añoInicio = entradaSolista.nextInt();

       Solista solista = new Solista(apellido, nombre, nacionalidad, tocaInstrumento, genero, añoInicio, discografica);
       colecciones.agregarMusico(solista);
       return solista;
  }
  
  private static Cancion registrarCancion(SistemaDeGestion colecciones) {
        Scanner inCancion= new Scanner(System.in);
        Cancion cancion;
        
        System.out.println("Registra una canción");
        System.out.println("Ingrese el título de la canción:");
        String titulo = inCancion.nextLine();
        System.out.println("Ingrese la duración en segundos de la canción:");
        int duracion = inCancion.nextInt();
        cancion = new Cancion(titulo, duracion);
        colecciones.agregarCancion(cancion);
        return cancion;
       
    }
  
  private static void registrarBanda(SistemaDeGestion sistemaDeGestion){
      
                   
      List<Solista> solistasBanda = new ArrayList<>();

      String ingresarNuevoIntegrante = "NO";
      Scanner entradaBanda = new Scanner(System.in);
      System.out.println("Registro de banda");
      System.out.println("Para comenzar, ingrese el nombre de la banda:");
      String nombre = entradaBanda.nextLine();
      System.out.println("Indique su genero musical:");
      String genero = entradaBanda.nextLine();
        
      System.out.println("Ingrese los datos de los integrantes");
      do {
                 solistasBanda.add(registrarSolista(sistemaDeGestion));
                 System.out.println("Quieres ingresar un nuevo solista? Responde SI/NO");
                ingresarNuevoIntegrante = entradaBanda.nextLine();

      } while(ingresarNuevoIntegrante.equals("SI"));
      
      System.out.println("Ingrese la discografica a la que pertenece:");
      String discografica = entradaBanda.nextLine();
      System.out.println("Ingrese el año de inicio de su carrera musical:");
      int añoInicio = entradaBanda.nextInt();
      Banda banda = new Banda (nombre, solistasBanda, genero, añoInicio, discografica );
      sistemaDeGestion.agregarMusico(banda);
      
  }
  
  private static void registrarDisco(SistemaDeGestion sistemaDeGestion){
      
       if(!sistemaDeGestion.getMusicos().isEmpty()){
                     
            String ingresarNuevaCancion = "SI";
             Scanner entradaDisco = new Scanner(System.in);
            System.out.println("Para registrar un disco previamente debe haber cargado el musico al cual le pertenece en las opciones 1 o 2 del menu principal");
      
            //obtener musico ya previamente cargado
             sistemaDeGestion.listarMusicos();
             System.out.println("Ingrese el numero que corresponde al artista a elegir:");
             Scanner entrada = new Scanner(System.in);
             int index = entrada.nextInt();
             Musico musico = sistemaDeGestion.obtenerMusicoPorIndex(index);
      
      
             System.out.println("Ingrese el título del disco:");
             String titulo = entradaDisco.nextLine();
      
            HashSet<Cancion> cancionesDisco = new HashSet<>();
             System.out.println("A continuación cargaremos las canciones del disco:");

      while(ingresarNuevaCancion.equals("SI")) {
          
           if (cancionesDisco.add(registrarCancion(sistemaDeGestion))) { //Si devuelve true, significa que se agregó
                    System.out.println("Cancion ingresada correctamente");
                } else{
                    System.out.println("Canción repetida");
                }
                 System.out.println("Quieres ingresar una nueva canción? Responde SI/NO");
                ingresarNuevaCancion = entradaDisco.nextLine();

      } 
      
      System.out.println("Por último, indique el año de edición del disco");
      int añoEdicion = entradaDisco.nextInt();
      Disco disco = new Disco (añoEdicion, cancionesDisco, titulo, musico );
      sistemaDeGestion.agregarDisco(disco);
      sistemaDeGestion.listarDiscos();
          
      } else {
         System.out.println("Para continuar, primero debes cargar el musico del disco en opcion 1 o 2");
      }
              
  }
  
  
  private static void listarDiscosPorMusico(SistemaDeGestion sistemaDeGestion){
        sistemaDeGestion.listarMusicos();
        System.out.println("Ingrese el numero correspondiente al artista a elegir:");
        Scanner entrada = new Scanner(System.in);
        int index = entrada.nextInt();
        Musico musico = sistemaDeGestion.obtenerMusicoPorIndex(index);
        sistemaDeGestion.obtenerDiscoPorMusico(musico);
  }
  
     private static void mostrarConsultas(){
        System.out.println("    GESICAL - Sistema de Gestión Musical");
        System.out.println("                Consultas");
        System.out.println("===============================");
        System.out.println("a.- Discos que duran mas que X segundos");
        System.out.println("b.- Playlist por género musical");
        System.out.println("c.- Borrar discus según año de edición");  
        System.out.println("d.- Listar discos por banda"); 
        System.out.println(" ");
        System.out.println("z.- Volver al menú anterior");    
    }
        
        private static void consultar(String opcion, SistemaDeGestion sistemaDeGestion){
            Scanner ent = new Scanner(System.in);
            String in=opcion;
             while(!in.equals("z")){
                 switch(in){
                     case "a":
                         System.out.println("Discos que duran mas de X segundos");
                         discosConMasDeXSegundos(sistemaDeGestion);
                     break;                   
                     case "b":
                         System.out.println("Playlist por género musical");
                         playlistPorGenero(sistemaDeGestion);
                     break;
                     case "c":
                         System.out.println("Borrar discos según año de edición");
                            borrarDiscosSegunAnoDeEdicion(sistemaDeGestion);
                     break;
                     case "d":
                         System.out.println(" Listar discos por banda");
                         listarDiscosPorMusico(sistemaDeGestion);
                         break;
                                
             }
                 mostrarConsultas();
                 in = ent.nextLine() ;             }   
             
        }

    private static void playlistPorGenero(SistemaDeGestion sistemaDeGestion) {
         System.out.println("Para armar tu playlist, te pediremos que ingreses el género musical que deseas:");
        Scanner entrada = new Scanner(System.in);
        String genero = entrada.nextLine();
        sistemaDeGestion.obtenerDiscosPorGenero(genero);
        
    }

    private static void borrarDiscosSegunAnoDeEdicion(SistemaDeGestion sistemaDeGestion) {
        System.out.println("Ingrese el año de edición de los discos a borrar. Se borrarán todos los discos previos a dicho año:");
        Scanner entrada = new Scanner(System.in);
        int año = entrada.nextInt();
        sistemaDeGestion.borrarDiscosSegunAño(año);      
    }

    private static void discosConMasDeXSegundos(SistemaDeGestion sistemaDeGestion) {
      System.out.println("Busqueda por tiempo de disco. Se listarán los discos que duren más que dichos segundos");
      System.out.println("Ingrese la cantidad de segundos:");
      Scanner entrada = new Scanner(System.in);        
      int segundos = entrada.nextInt();
      sistemaDeGestion.listarDiscosPorTiempo(segundos);
    } 
    
    private static void registroMasivo(SistemaDeGestion sistemaDeGestion){
                
      Solista solista = new Solista("Esposito", "Lalo", "argentina", true, "Cumbia", 2010, "Records");
       sistemaDeGestion.agregarMusico(solista);
      Solista solista2 = new Solista("Soledad", "Pastoruti", "argentina", true, "Pop", 2015, "Records");
       sistemaDeGestion.agregarMusico(solista2);
        Solista solista3 = new Solista("Estusel", "Tino", "argentina", true, "Rock", 2020, "Records");
       sistemaDeGestion.agregarMusico(solista3);
        Solista solista4 = new Solista("Guarani", "Hora", "argentina", true, "Folcklore", 1900, "Records");
       sistemaDeGestion.agregarMusico(solista4);
      Solista solista5 = new Solista("Mollo", "Natalia", "argentina", true, "Cumbia",1990, "Records");
       sistemaDeGestion.agregarMusico(solista5);
      Solista solista6 = new Solista("Perez", "Nata", "argentina", true, "Pop", 2000, "Records");
       sistemaDeGestion.agregarMusico(solista6);
        Solista solista7 = new Solista("Cantillo", "Fabi", "argentina", true, "Cumbia", 1980, "Records");
       sistemaDeGestion.agregarMusico(solista7);
        Solista solista8 = new Solista("Guarani", "Hora", "argentina", true, "Folcklore", 1900, "Records");
       sistemaDeGestion.agregarMusico(solista8);
          Solista solista9 = new Solista("Garcia", "Carlos", "argentina", true, "Rock", 1970, "Records");
       sistemaDeGestion.agregarMusico(solista9);
        Solista solista10 = new Solista("Paez", "Fito", "argentina", true, "Rock", 1990, "Records");
       sistemaDeGestion.agregarMusico(solista10);
       
        List<Solista> solistas1 = new LinkedList<>();
        solistas1.add(solista10);
        solistas1.add(solista9);
        
        List<Solista> solistas2 = new LinkedList<>();
        solistas1.add(solista);
        solistas1.add(solista2);
        solistas1.add(solista3);
       
        Banda banda1 = new Banda ("Los Tipitos", solistas1, "Rock",1995, "Records" );
        sistemaDeGestion.agregarMusico(banda1);
        Banda banda2 = new Banda ("Bandana", solistas2, "Pop",2000, "Records" );
        sistemaDeGestion.agregarMusico(banda2);

        sistemaDeGestion.agregarCancion((new Cancion("Eiti Leda", 400)));
        sistemaDeGestion.agregarCancion(new Cancion("Desarma y sangra", 200));
        sistemaDeGestion.agregarCancion(new Cancion("¨Petalo de sal", 240));
        sistemaDeGestion.agregarCancion(new Cancion("Crimenes perfectos", 300));
        sistemaDeGestion.agregarCancion(new Cancion("Los dias felices", 200));
        sistemaDeGestion.agregarCancion(new Cancion("Nos veremos otra vez", 180));
        sistemaDeGestion.agregarCancion(new Cancion("Te quiero igual", 300));
        sistemaDeGestion.agregarCancion(new Cancion("Azucar Amargo", 190));
        sistemaDeGestion.agregarCancion(new Cancion("Parque acuatico", 160));
        sistemaDeGestion.agregarCancion(new Cancion("Circo beat", 300));
        sistemaDeGestion.agregarCancion(new Cancion("El arriero", 400));
        sistemaDeGestion.agregarCancion(new Cancion("Samba", 200));
        sistemaDeGestion.agregarCancion(new Cancion("Los dinosaurios", 240));
        sistemaDeGestion.agregarCancion(new Cancion("blues", 300));
        sistemaDeGestion.agregarCancion(new Cancion("sobreviviendo", 210));
        sistemaDeGestion.agregarCancion(new Cancion("Nos siguen pegando abajo", 180));
        sistemaDeGestion.agregarCancion(new Cancion("La rueda magica", 150));
        sistemaDeGestion.agregarCancion(new Cancion("Estadio Azteca", 190));
        sistemaDeGestion.agregarCancion(new Cancion("Loco", 160));
        sistemaDeGestion.agregarCancion(new Cancion("Luna de miel", 300));
        
        
        
         
        HashSet<Cancion> cancionesDisco1 = new HashSet<>();
        cancionesDisco1.add(new Cancion("Alicia en la utn", 400));
        cancionesDisco1.add(new Cancion("Yendo a la facu en cole", 200));
        cancionesDisco1.add(new Cancion("Muchos libros", 300));
        

        HashSet<Cancion> cancionesDisco2 = new HashSet<>();
        cancionesDisco2.add(new Cancion("La vuelta", 180));
        cancionesDisco2.add(new Cancion("Volvio bandana", 300));
        
        HashSet<Cancion> cancionesDisco3 = new HashSet<>();
        cancionesDisco3.add(new Cancion("Mariposa Tecknicolor", 170));
        cancionesDisco3.add(new Cancion("Un vestido y un amor", 220));
        cancionesDisco3.add(new Cancion("Brillante sobre el mic", 180));

        
         Disco disco1 = new Disco (1990, cancionesDisco1, "La utn", solista9 );
         Disco disco2 = new Disco (2010, cancionesDisco2, "las bandanas", banda2 );
         Disco disco3 = new Disco (2020, cancionesDisco3, "Canciones de rock", solista10 );

        sistemaDeGestion.agregarDisco(disco1);
        sistemaDeGestion.agregarDisco(disco2);
        sistemaDeGestion.agregarDisco(disco3);

       
    }
 
}
