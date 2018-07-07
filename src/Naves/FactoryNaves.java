/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Naves;

import AbstractFactory.AbstractFactory;
import Enemigos.Alien;
import Enemigos.Enemigo;

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
        }
        return null;
    }
    @Override
    public Enemigo getEnemigo(int tipo){
        return null;
    }
}
