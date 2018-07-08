/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public class Vida extends PowerUp{
        @Override
        public void Iniciar(int WIDHT){
        this.posicionX=WIDHT;
        this.vidaExtra=5000;
        this.velocidad=3.5;
        try {
            this.imagen = new Image("Img/Vida.gif");
        } catch (SlickException ex) {
            Logger.getLogger(Vida.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Hitbox= new Rectangle(this.posicionX, this.posicionY, imagen.getWidth(), imagen.getHeight());
    }
}
