/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Naves;

import org.newdawn.slick.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public abstract class Nave {
    public int vida=0, ataque=0;
    public double velocidad, velocidadBala;
    public float posicionX=0, posicionY=0;
    public Image imagen;
    public Rectangle Hitbox;
    abstract public void Iniciar();
}
