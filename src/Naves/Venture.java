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
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public class Venture extends Nave{
    @Override
    public void Iniciar(){
        this.vida=10000;
        this.ataque=50;
        this.velocidad=1.2;
        this.velocidadBala=2.5;
        this.posicionX=0;
        this.posicionY=200;
        try {
            this.imagen= new Image("Img/Venture.gif");
        } catch (SlickException ex) {
            Logger.getLogger(Majesty.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Hitbox= new Rectangle(this.posicionX, this.posicionY, imagen.getWidth(), imagen.getHeight());
    }
}
