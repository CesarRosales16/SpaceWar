/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import AbstractFactory.AbstractFactory;
import Naves.Nave;

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
        }
        return null;
    }
    @Override
    public Nave getNave(int tipo){
        return null;
    }
}
