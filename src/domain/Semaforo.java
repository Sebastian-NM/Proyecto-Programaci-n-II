/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author LuisGa
 */
public class Semaforo {

    //hola mundo
    private int s = 1;
    public Semaforo(int inicial){
        s = inicial;
    }
    
    public synchronized void espera(){
        while(s<=0){
         try {
         this.wait();
         } catch (InterruptedException e){
         // lo ignora
         }
        }
//        s = s-1;
        s = 0;
    }
    
    public synchronized void signal(){
//        s = s+1;
        s = 1;
        notify();
    }

}
