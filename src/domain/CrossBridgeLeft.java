/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;

/**
 *
 * @author LuisGa
 */
public class CrossBridgeLeft implements Runnable{

    ImageView car;
    Semaforo mutex;
    Semaforo mL1;
    Semaforo mL2;
    Semaforo mL3;

    public CrossBridgeLeft(ImageView car, Semaforo mutex, Semaforo mL1, Semaforo mL2, Semaforo mL3) {
        this.car = car;
        this.mutex = mutex;
        this.mL1 = mL1;
        this.mL2 = mL2;
        this.mL3 = mL3;
    }

    @Override
    public synchronized void run() {
        
       
        for (int i = 0; i < 50; i++) {
            try {
                car.setLayoutX(car.getLayoutX()+1);
                Thread.sleep(15);
            } catch (InterruptedException ex) {
               ;
            }
        }
       
        
        for (int i = 0; i < 50; i++) {
            try {
                car.setLayoutX(car.getLayoutX()+1);
                Thread.sleep(15);
            } catch (InterruptedException ex) {
            }
        }
//        
        
        
        
        mutex.espera();
         for (int i = -100; i < 100; i++) {
            try {
                car.setLayoutX(car.getLayoutX()+1);
                if(i!=0)
                car.setLayoutY(car.getLayoutY()+(i/(Math.sqrt((Math.pow(i, 2))))));
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                
            }
        }
        mutex.signal();
         
        for (int i = 0; i < 50; i++) {
            try {
                car.setLayoutX(car.getLayoutX()+1);
                Thread.sleep(15);
            } catch (InterruptedException ex) {
            }
        }
        
        for (int i = 0; i < 50; i++) {
            try {
                car.setLayoutX(car.getLayoutX()+1);
                Thread.sleep(15);
            } catch (InterruptedException ex) {
           }
        }
//        
      car.setVisible(false);
         
    }
    
}
