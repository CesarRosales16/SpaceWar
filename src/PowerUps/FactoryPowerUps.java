/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps;

import AbstractFactory.AbstractFactory;
import Enemigos.Enemigo;
import Naves.Imperial;
import Naves.Majesty;
import Naves.Nave;
import Naves.Venture;

/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public class FactoryPowerUps implements AbstractFactory{
    @Override
    public PowerUp getPowerUp(int tipo){
        switch(tipo){
            case 1:
                return new Coin();
            case 2:
                 return new Velocidad();
            case 3:
                return new Vida();
        }
        return null;
    }
    @Override
    public Nave getNave(int tipo){

        return null;
    }
    @Override
    public Enemigo getEnemigo(int tipo){
        return null;
    }

}
