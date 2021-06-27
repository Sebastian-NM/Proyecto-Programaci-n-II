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
public class CrossRight implements Runnable {

    private ImageView car;
    private Semaforo mutexLeft;
    private Semaforo mutexRight;
    private Semaforo mutexRC;
    private Int counter;
    private Semaforo mR1;
    private Semaforo mR2;
    private Semaforo mR3;

    public CrossRight(ImageView Car, Semaforo mutexLeft, Semaforo mutexRight, Int counter, Semaforo mutexRC, Semaforo mR1, Semaforo mR2, Semaforo mR3) {
        this.car = Car;
        this.mutexLeft = mutexLeft;
        this.mutexRight = mutexRight;
        this.mutexRC = mutexRC;
        this.counter = counter;
        this.mR1 = mR1;
        this.mR2 = mR2;
        this.mR3 = mR3;
    }

    @Override
    public void run() {

        mR1.espera();
        for (int i = 0; i < 6; i++) {
            try {
                car.setLayoutX(car.getLayoutX() - 14);
                Thread.sleep(80);
            } catch (InterruptedException ex) {

            }
        }

        mR2.espera();
        mR1.signal();
        for (int i = 0; i < 6; i++) {
            try {
                car.setLayoutX(car.getLayoutX() - 14);
                Thread.sleep(80);
            } catch (InterruptedException ex) {

            }
        }
        mR3.espera();
        mR2.signal();
        for (int i = 0; i < 6; i++) {
            try {
                car.setLayoutX(car.getLayoutX() - 14);
                Thread.sleep(80);
            } catch (InterruptedException ex) {

            }
        }

        mutexLeft.espera();
        mutexLeft.signal();
        mutexRC.espera();
        counter.setN(counter.getN() + 1);
        if (counter.getN() == 1) {
            mutexRight.espera();
        }
        mutexRC.signal();

        mR3.signal();
        System.out.println("Derecha Entre al puente");
        for (int i = -13; i < 13; i++) {
            try {
                car.setLayoutX(car.getLayoutX() - 20);
                if (i != 0) {
                    car.setLayoutY(car.getLayoutY() + 3 * (i / (Math.sqrt((Math.pow(i, 2))))));
                }
                Thread.sleep(120);
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Derecha Sali del puente");

        mutexRC.espera();

        counter.setN(counter.getN() - 1);
        if (counter.getN() == 0) {
            mutexRight.signal();
        }
        mutexRC.signal();

        for (int i = 0; i < 17; i++) {
            try {
                car.setLayoutX(car.getLayoutX() - 20);
                Thread.sleep(120);
            } catch (InterruptedException ex) {

            }
        }



    }

}
