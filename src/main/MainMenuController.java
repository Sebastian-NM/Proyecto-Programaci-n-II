/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author LuisGa
 */
public class MainMenuController implements Initializable {

    @FXML
    private AnchorPane PaneRoot;
    @FXML
    private Button btnStartL;
    @FXML
    private Button btnStartR;
    
    Semaforo mutex;
    Semaforo mR1;
    Semaforo mR2;
    Semaforo mR3;
    Semaforo mL1;
    Semaforo mL2;
    Semaforo mL3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        mutex = new Semaforo(1);
        mR1 = new Semaforo(1);
        mR2 = new Semaforo(1);
        mR3 = new Semaforo(1);
        mL1 = new Semaforo(1);
        mL2 = new Semaforo(1);
        mL3 = new Semaforo(1);
       
    }

    @FXML
    private void btnStartL(ActionEvent event) {
 
        ImageView car = new ImageView(new Image("/Images/car.png"));
        PaneRoot.getChildren().addAll(car);
        car.setScaleX(-1);
        car.setScaleY(1);
        car.setFitHeight(100);
        car.setFitWidth(200);
        car.setLayoutX(-150);
        car.setLayoutY(250);
       
    
        CrossBridgeLeft c = new CrossBridgeLeft(car, mutex, mL1, mL2, mL3);
        Thread t = new Thread(c);
        t.start();
        
        
    }

    @FXML
    private void btnStartR(ActionEvent event) {
        
        ImageView car = new ImageView(new Image("/Images/car.png"));
        PaneRoot.getChildren().add(car);
        car.setScaleX(1);
        car.setScaleY(1);
        car.setFitHeight(100);
        car.setFitWidth(200);
        car.setLayoutX(900);
        car.setLayoutY(180);
        
        CrossBridgeRight c = new CrossBridgeRight(car, mutex, mR1, mR2, mR3);
        Thread t = new Thread(c);
        t.start();
        
    }
    
    
    
}
