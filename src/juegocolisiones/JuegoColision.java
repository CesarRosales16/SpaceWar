package juegocolisiones;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class JuegoColision extends BasicGame {

    private boolean choque = false;
    private boolean disparo = false;
    private Image nave, alien, misil;
    private Input entrada;
    private Rectangle naveRect, alienRect;
    float alienX = 500, alienY =80;
    float naveX = 0, naveY = 75;
    float misilX = 0, misilY = 0;
    final static int WIDHT = 640, HEIGHT = 400;
    int flagMov = 0;

    /**
     * @param args the command line arguments
     */
    public JuegoColision() {
        super("colisiones");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        nave = new Image("Img/Nave.gif");
        alien = new Image("Img/Alien.gif");
        misil = new Image("Img/Misil.png");
        entrada = gc.getInput();
        naveRect = new Rectangle(naveX, naveY, nave.getWidth(), nave.getHeight());
        alienRect = new Rectangle(alienX, alienY, alien.getWidth(), alien.getHeight());
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        verificar();
        actualizarNaveJugador();
        actualizarNaveEnemigos();

        //    gc.sleep(18);
    }

    @Override
    public void render(GameContainer gc, Graphics grafico) throws SlickException {
        nave.draw(naveX, naveY);
        alien.draw(alienX, alienY);
        //grafico.drawRect(alienRect.getX(), alienRect.getY(), alienRect.getWidth(), alienRect.getHeight());
        //grafico.drawRect(naveRect.getX(), naveRect.getY(), naveRect.getWidth(), naveRect.getHeight());
        if (choque) {
            grafico.drawString("Has perdido!!!", 20, HEIGHT - 40);
        }
        if (disparo) {
            misil.draw(misilX, misilY);
            Rectangle misilRect = new Rectangle(misilX, misilY, misil.getWidth(), misil.getHeight());
            //grafico.drawRect(misilRect.getX(), misilRect.getY(), misilRect.getWidth(), misilRect.getHeight());
            misilX += 0.2;
            misilRect.setX(misilX);
            if (misilRect.intersects(alienRect)) {
                alien.destroy();
            }
        }

    }

    public static void main(String[] args) {
        try {
            AppGameContainer gc = new AppGameContainer(new JuegoColision());
            gc.setDisplayMode(WIDHT, HEIGHT, false);
            gc.start();
        } catch (SlickException err) {
            err.printStackTrace();
        }
    }

    private void actualizarNaveJugador() throws SlickException {
        if (entrada.isKeyPressed(Input.KEY_SPACE)) {
            flagMov = 1;
        }
        if (flagMov == 1) {
            if (entrada.isKeyDown(Input.KEY_SPACE)) {
                naveY -= 0.15;
            } else {
                naveY += 0.15;
            }
            if (entrada.isKeyPressed(Input.KEY_G)) {
                disparar();
                disparo = true;
            }
            naveRect.setY(naveY);
        }

    }

    public void actualizarNaveEnemigos() {
        if (!alien.isDestroyed()) {
            alienX -= 0.1;
            alienRect.setX(alienX);
        }
    }

    private void verificar() throws SlickException {
        if (naveY > HEIGHT - nave.getHeight() || naveY < 0) {  //FALTA VALIDAR LA COLISION CON PARTE INFERIOR!!
            choque = true;
        }
        if (alienRect.intersects(naveRect)) {
            choque = true;
            alien.destroy();
        }
    }

    public void disparar() throws SlickException {
        misilX = nave.getWidth();
        misilY = naveY+(nave.getHeight()/2);
    }
}
