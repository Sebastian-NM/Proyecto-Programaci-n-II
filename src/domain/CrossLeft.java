/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.scene.image.ImageView;

/**
 *
 * @author LuisGa
 */
public class CrossLeft implements Runnable {

    private ImageView car;
    private Semaforo mutexLeft;
    private Semaforo mutexRight;
    private Semaforo mutexRC;
    private Int counter;
    private Semaforo mL1;
    private Semaforo mL2;
    private Semaforo mL3;

    public CrossLeft(ImageView Car, Semaforo mutexLeft, Semaforo mutexRight, Int counter, Semaforo mutexRC, Semaforo mL1, Semaforo mL2, Semaforo mL3) {
        this.car = Car;
        this.mutexLeft = mutexLeft;
        this.mutexRight = mutexRight;
        this.mutexRC = mutexRC;
        this.counter = counter;
        this.mL1 = mL1;
        this.mL2 = mL2;
        this.mL3 = mL3;
    }

    @Override
    public void run() {

        car.toFront();
        mL1.espera();
        for (int i = 0; i < 6; i++) {
            try {
                car.setLayoutX(car.getLayoutX() + 14);
                Thread.sleep(80);
            } catch (InterruptedException ex) {

            }
        }

        mL2.espera();
        mL1.signal();
        for (int i = 0; i < 6; i++) {
            try {
                car.setLayoutX(car.getLayoutX() + 14);
                Thread.sleep(80);
            } catch (InterruptedException ex) {

            }
        }
        mL3.espera();
        mL2.signal();
        for (int i = 0; i < 6; i++) {
            try {
                car.setLayoutX(car.getLayoutX() + 14);
                Thread.sleep(80);
            } catch (InterruptedException ex) {

            }
        }
        
        
        //*******************************************************
        mutexRight.espera();
        mutexRight.signal();
        mutexRC.espera();
        counter.setN(counter.getN() + 1);
        if (counter.getN() == 1) {
            mutexLeft.espera();
        }
        mutexRC.signal();
        //********************************************************
        
        
        mL3.signal();
        System.out.println("Izquierda Entre al puente");
        for (int i = -13; i < 13; i++) {
            try {
                car.setLayoutX(car.getLayoutX() + 20);
                if (i != 0) {
                    car.setLayoutY(car.getLayoutY() + 9 * (i / (Math.sqrt((Math.pow(i, 2))))));
                }
                Thread.sleep(120);
            } catch (InterruptedException ex) {

            }
        }

        System.out.println("Izquierda Sali del puente");

        //******************************************************
        mutexRC.espera();
        counter.setN(counter.getN() - 1);
        if (counter.getN() == 0) {
            mutexLeft.signal();
        }
        mutexRC.signal();
        //******************************************************

        for (int i = 0; i < 15; i++) {
            try {
                car.setLayoutX(car.getLayoutX() + 20);
                Thread.sleep(120);
            } catch (InterruptedException ex) {

            }
        }



    }

}
