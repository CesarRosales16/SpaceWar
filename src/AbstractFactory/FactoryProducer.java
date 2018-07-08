package AbstractFactory;


import Enemigos.FactoryEnemigos;
import Naves.FactoryNaves;
import PowerUps.FactoryPowerUps;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String type){
        switch (type){
            case "Enemigos":
                return new FactoryEnemigos();     
            case "Naves":
                return new FactoryNaves();
            case "PowerUps":
                return new FactoryPowerUps();
        }
        return null;
    }
}
