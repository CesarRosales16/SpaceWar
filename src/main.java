
import juegocolisiones.JuegoColision;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro Olmedo <00097017@uca.edu.sv>
 */
public class main{
    public static void main(String[] args) {
        try {
            final int WIDHT = 640, HEIGHT = 400;
            AppGameContainer gc = new AppGameContainer(new JuegoColision());
            gc.setDisplayMode(WIDHT, HEIGHT, false);
            gc.setVSync(true);
            gc.start();
        } catch (SlickException err) {
            err.printStackTrace();
        }
    }
}

