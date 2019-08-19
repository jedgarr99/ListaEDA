


package listaeda;

public class ListaEDA {

    public static void main(String[] args) {
               Lista a = new Lista();
        a.agrega("1");
        a.agrega("2");
        a.agrega("3");
        a.agrega("4");
        a.agrega("5");
        a.agrega("6");
        
        
        System.out.println(a.toString());
    
        a.invierteDatos();
        System.out.println("");
        System.out.println(a.toString());
         
       
    }
}
