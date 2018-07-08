package AbstractFactory;


import Enemigos.Enemigo;
import Naves.Nave;
import PowerUps.PowerUp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
 public interface AbstractFactory {
        Enemigo getEnemigo(int tipo);
        Nave getNave(int tipo);
        PowerUp getPowerUp(int tipo);
}
