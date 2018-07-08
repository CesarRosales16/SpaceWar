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
import org.newdawn.slick.geom.*;
/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public class Majesty extends Nave{
    @Override
    public void Iniciar(){
        this.vida=17500;
        this.ataque=100;
        this.velocidad=2.5;
        this.velocidadBala=4;
        this.posicionX=0;
        this.posicionY=200;
        this.precio=10000;
        try {
            this.imagen= new Image("Img/Nave.gif");
        } catch (SlickException ex) {
            Logger.getLogger(Majesty.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Hitbox= new Rectangle(this.posicionX, this.posicionY, imagen.getWidth(), imagen.getHeight());
    }
        @Override
    public void setearPrecio() {
        this.precio = 10000;
    }
}
