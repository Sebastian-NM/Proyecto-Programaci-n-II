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
public class CrossBridgeRight implements Runnable{

    ImageView car;
    Semaforo mutex;
    Semaforo mR1;
    Semaforo mR2;
    Semaforo mR3;

    public CrossBridgeRight(ImageView car, Semaforo mutex, Semaforo mR1, Semaforo mR2, Semaforo mR3) {
        this.car = car;
        this.mutex = mutex;
        this.mR1 = mR1;
        this.mR2 = mR2;
        this.mR3 = mR3;
    }

    @Override
    public synchronized void run() {
        
//        
        for (int i = 0; i < 50; i++) {
            try {
                car.setLayoutX(car.getLayoutX()-2.5);
                Thread.sleep(15);
            } catch (InterruptedException ex) {
               
            }
        }
        
     
        
        for (int i = 0; i < 50; i++) {
            try {
                car.setLayoutX(car.getLayoutX()-2.5);
                Thread.sleep(15);
            } catch (InterruptedException ex) {
               
            }
        }
//        
//        
//        
       
        mutex.espera();
         for (int i = -100; i < 100; i++) {
            try {
                car.setLayoutX(car.getLayoutX()-2.5);
                if(i!=0)
                car.setLayoutY(car.getLayoutY()+(i/(Math.sqrt((Math.pow(i, 2))))));
                Thread.sleep(15);
            } catch (InterruptedException ex) {
            }
        }
        mutex.signal();
        
      
        for (int i = 0; i < 50; i++) {
            try {
                car.setLayoutX(car.getLayoutX()-2.5);
                Thread.sleep(15);
            } catch (InterruptedException ex) {
               
            }
        }
        
        for (int i = 0; i < 75; i++) {
            try {
                car.setLayoutX(car.getLayoutX()-2.5);
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                
            }
        }
        
       car.setVisible(false);
    }
    

}
