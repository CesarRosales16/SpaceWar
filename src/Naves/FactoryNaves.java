/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Naves;

import AbstractFactory.AbstractFactory;
import Enemigos.Alien;
import Enemigos.Enemigo;
import PowerUps.PowerUp;

/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public class FactoryNaves implements AbstractFactory{
    @Override
    public Nave getNave(int tipo){
        switch(tipo){
            case 1:
                return new Venture();
            case 2:
                 return new Majesty();
            case 3:
                return new Imperial();
        }
        return null;
    }
    @Override
    public Enemigo getEnemigo(int tipo){
        return null;
    }
    @Override
    public PowerUp getPowerUp(int tipo){
        return null;
    }
}
