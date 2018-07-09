/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class BlackHole extends Enemigo{
    @Override
    public void Iniciar(int WIDHT){
        this.posicionX=WIDHT;
        this.posicionY = 80;
        this.ataque = 1000000000;
        this.vida = 800;
        this.velocidad = 1;
        this.puntuacion=2000;
        try {
            this.imagen = new Image("Img/Hoyo.png");
        } catch (SlickException ex) {
            Logger.getLogger(Alien.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.enemigoRect = new Rectangle(this.posicionX, this.posicionY, imagen.getWidth(), imagen.getHeight());
    }
}
