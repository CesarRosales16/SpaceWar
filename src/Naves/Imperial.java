/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Naves;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class Imperial extends Nave {

    @Override
    public void Iniciar() {
        this.vida = 30000;
        this.ataque = 150;
        this.velocidad = 4.5;
        this.velocidadBala = 6;
        this.posicionX = 0;
        this.posicionY = 200;
        this.precio=30000;
        try {
            this.imagen = new Image("Image/3.gif");
        } catch (SlickException ex) {
            Logger.getLogger(Majesty.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Hitbox = new Rectangle(this.posicionX, this.posicionY, imagen.getWidth(), imagen.getHeight());
    }
    @Override
    public void setearPrecio() {
        this.precio = 30000;
    }
}
