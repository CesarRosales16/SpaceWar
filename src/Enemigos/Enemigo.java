/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.*;
/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public abstract class Enemigo {
    public int vida=0, ataque=0, puntuacion=0;
    public double velocidad;
    public float posicionX=0, posicionY=0;
    public Image imagen;
    public Rectangle enemigoRect;
    abstract public void Iniciar(int WIDHT);
}
