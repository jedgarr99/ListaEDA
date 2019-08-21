/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listaeda;

import java.util.ArrayList;

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
   
     public void invierteD(){
         invierteD(cabeza.getSig());
     }
     private Nodo<T> invierteD(Nodo<T> act){
         if (act==null)
             return cabeza.getSig();
         
         T temp=act.getDato();
         Nodo<T> nodo =invierteD(act.getSig());
         
          nodo.setDato(temp);
 
                 return nodo.getSig();
                 
     }
     public  void permuta(String s1, String s2){
         if(s1.length()==0)
             System.out.println(s2);
         for (int i=0; i<s1.length();i++){
             char p=s1.charAt(i);
             String resto=s1.substring(0, i)+s1.substring(i+1);
             permuta(resto, p+s2);
         }
     }
     public void permutaR(String palabra){

         permutaR(palabra,"",0,palabra.length());
     }
     private void permutaR(String s1,String s2, int n,int k){
         if(s1.length()==0){
             System.out.println(s2);
         }
         
             if(n<k){
                 char p=s1.charAt(n);
                 String resto= s1.substring(0, n)+s1.substring(n+1);
                 
                 permutaR(resto, p+s2,n+1,k);
             }
     }
    
 
             

   
}
    
   
