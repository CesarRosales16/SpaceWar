/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUps;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public abstract class PowerUp {
    public int vidaExtra=0, puntuacionExtra=0, posicionX=0, posicionY=0;
    public double velocidad=0, velocidadExtra=0;
    public Image imagen;
    public Rectangle Hitbox;
    abstract public void Iniciar(int WIDHT);
}
