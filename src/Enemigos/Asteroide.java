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
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public class Asteroide extends Enemigo {

    @Override
    public void Iniciar(int WIDHT) {
        this.posicionX=WIDHT;
        this.posicionY = 80;
        this.ataque = 100;
        this.vida = 100;
        this.velocidad = 2;
        this.puntuacion=500;
        try {
            this.imagen = new Image("Img/Asteroide.png");
        } catch (SlickException ex) {
            Logger.getLogger(Alien.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.enemigoRect = new Rectangle(this.posicionX, this.posicionY, imagen.getWidth(), imagen.getHeight());
    }
}
