/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import AbstractFactory.AbstractFactory;
import Naves.Nave;
import PowerUps.PowerUp;

/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public class FactoryEnemigos implements  AbstractFactory{
    @Override
    public Enemigo getEnemigo(int tipo){
        switch(tipo){
            case 1:
                return new Alien();
            case 2:
                return new Asteroide();
            case 3:
                return new BlackHole(); 
        }
        return null;
    }
    @Override
    public Nave getNave(int tipo){
        return null;
    }
    @Override
    public PowerUp getPowerUp(int tipo){
        return null;
    }
}
