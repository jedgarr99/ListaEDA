/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaeda;

/**
 *
 * @author jrodriguort
 */
public class Lista <T> {
    private Nodo<T> cabeza;
    private int cant;
    
   
    public Lista(){
        cabeza= new Nodo();
        cant=0;
    }
    public int agrega(T dato){
        Nodo<T> nuevo= new Nodo(dato);
        Nodo<T> actual=cabeza;
       
        while(actual.getSig()!=null)
            actual=actual.getSig();
        actual.setSig(nuevo);
        cant++;
       
        return cant;  
    }
    public void imprime(){
        imprime(cabeza.getSig());
    }
    private void imprime(Nodo actual){
        if(actual==null)
            return;
        Object dato= actual.getDato();
        System.out.print(dato.toString()+"  ");
        imprime(actual.getSig());
    }
    public String toString() {
        StringBuilder res = new StringBuilder();
        return toString(res, cabeza.getSig());
    }

    private String toString(StringBuilder res, Nodo<T> actual) {
        if (actual == null) {
            return res.toString();
        } else {
            res.append(actual.getDato()).append("\n");
            return toString(res, actual.getSig());
        }
    }
    public int cuenta(){
        int i=0;
        return cuenta(i, cabeza.getSig());
    }
    private int cuenta(int i, Nodo<T> actual){
        if(actual==null)
            return i;
        return cuenta(i+1, actual.getSig());
    }
    public void elimina(T dato){
        elimina( cabeza, cabeza.getSig(), dato);
    }
    private void elimina(Nodo<T> ant, Nodo<T> actual, T dato){
        if(actual==null)
            return;
        if(actual.getDato().equals(dato)){
            ant.setSig(actual.getSig());
            actual.setSig(null);
            cant --;
        }
        elimina(ant.getSig(),actual.getSig(), dato);
    }
    public boolean isEmpty(){
        return cant==0;
    }
    public void invierte(){
        invierte(cabeza.getSig());
    }
    private  void invierte(Nodo<T> act){
        if(act.getSig()==null)
            cabeza.setSig(act);
        else{
            invierte(act.getSig());
            System.out.println("act "+act.toString());
            act.getSig().setSig(act);
            act.setSig(null);
        }    
    }
   
    public void invierteDatos(){
        if(!isEmpty()){
            invierteDatos(cabeza.getSig(), cabeza.getSig());  
            System.out.println("no esta vacia");
        }
            
    }
     private void invierteDatos(Nodo<T> in , Nodo<T> fin){

             if(fin==null){
                 System.out.println("nada");
             }
             else{
                 
                 invierteDatos(in, fin.getSig());
                 System.out.println("fin "+fin.toString());
                 System.out.println("in  "+in.toString()); 
                 System.out.println(in.getSig());
                 T aux= fin.getDato();
                 fin.setDato(in.getDato());
                 in.setDato(aux);
                 in=in.getSig();
                 //System.out.println("fin "+fin.toString());
                // System.out.println("in  "+in.toString()); 
                 System.out.println("");
                
             }
                 
            
        //}
     }
     public void invierteDatos2(){
        if(!isEmpty()){
            invierteDatos2(cabeza.getSig(), cabeza.getSig());  
            System.out.println("no esta vacia");
        }
            
    }
     private void invierteDatos2(Nodo<T> in , Nodo<T> fin){

             if(fin==null){
                 System.out.println("nada");
             }
             else{
                 
                 invierteDatos2(in, fin.getSig()); 
             }
                 
            
        //}
     }

   
}