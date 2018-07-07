package juegocolisiones;

import AbstractFactory.AbstractFactory;
import AbstractFactory.FactoryProducer;
import Enemigos.Enemigo;
import Enemigos.FactoryEnemigos;
import Naves.Nave;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
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
    private boolean disparoDisponible = true;
    private Image misil;
    private Input entrada;
    float misilX = 0, misilY = 0;
    final static int WIDHT = 640, HEIGHT = 400;
    int flagMov = 0;
    public int puntuacion = 0;
    AbstractFactory factory = FactoryProducer.getFactory("Naves");
    Nave nave = factory.getNave(2);
    ArrayList<Enemigo> listaEnemigos = new ArrayList<>();
    ArrayList<Enemigo> listaEnemigosRemovidos = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public JuegoColision() {
        super("colisiones");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        misil = new Image("Img/Misil.png");
        entrada = gc.getInput();
        nave.Iniciar();
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        actualizarNaveJugador();
        actualizarNaveEnemigos();
        spawnearEnemigos();

    }

    @Override
    public void render(GameContainer gc, Graphics grafico) throws SlickException {
        grafico.drawString("Salud: " + nave.vida, 20, HEIGHT - 40);
        grafico.drawString("Puntuacion: " + puntuacion, WIDHT - 150, HEIGHT - 40);
        nave.imagen.draw(nave.posicionX, nave.posicionY);
        grafico.drawRect(nave.Hitbox.getX(), nave.Hitbox.getY(), nave.Hitbox.getWidth(), nave.Hitbox.getHeight());

        if (disparo) {
            misil.draw(misilX, misilY);
            Rectangle misilRect = new Rectangle(misilX, misilY, misil.getWidth(), misil.getHeight());
            grafico.drawRect(misilRect.getX(), misilRect.getY(), misilRect.getWidth(), misilRect.getHeight());
            misilX += nave.velocidadBala;
            misilRect.setX(misilX);
            if (misilX>=WIDHT-20) {
                disparoDisponible = true;
            }
            disparar(misilRect);
        }
        for (Enemigo e : listaEnemigos) {
            e.imagen.draw(e.posicionX, e.posicionY);
            grafico.drawRect(e.enemigoRect.getX(), e.enemigoRect.getY(), e.enemigoRect.getWidth(), e.enemigoRect.getHeight());
        }
        verificar(grafico);

    }

    private void spawnearEnemigos() {
        double randomNum = ThreadLocalRandom.current().nextDouble(0, 100);
        int enemigo=1;
        if (randomNum < 2) {
            AbstractFactory factory = FactoryProducer.getFactory("Enemigos");
            if(randomNum<0.3){
                enemigo=2;
            }
            Enemigo enem = factory.getEnemigo(enemigo);
            int posicionBrandom = ThreadLocalRandom.current().nextInt(0, HEIGHT);
            enem.Iniciar();
            enem.posicionY = posicionBrandom;
            enem.enemigoRect.setY(enem.posicionY);
            for (Enemigo e : listaEnemigos) {
                if (enem.enemigoRect.intersects(e.enemigoRect)) {
                    return;
                }
            }
            listaEnemigos.add(enem);
        }
    }

    private void actualizarNaveJugador() throws SlickException {
        if (entrada.isKeyPressed(Input.KEY_SPACE)) {
            flagMov = 1;
        }
        if (flagMov == 1) {
            if (entrada.isKeyDown(Input.KEY_SPACE)) {
                nave.posicionY -= nave.velocidad;
            } else {
                nave.posicionY += nave.velocidad;
            }
            if (entrada.isKeyPressed(Input.KEY_F) && disparoDisponible) {
                misilX = nave.imagen.getWidth();
                misilY = nave.posicionY + (nave.imagen.getHeight() / 2);
                disparo = true;
                disparoDisponible = false;
            }
            nave.Hitbox.setY(nave.posicionY);
        }

    }

    private void actualizarNaveEnemigos() {

        for (Enemigo e : listaEnemigos) {
            e.posicionX -= e.velocidad;
            e.enemigoRect.setX(e.posicionX);
        }

    }

    private Graphics verificar(Graphics grafico) throws SlickException {
        if (nave.posicionY > HEIGHT - nave.imagen.getHeight() || nave.posicionY < 0) {
            nave.vida -= 60;
        }
        for (Enemigo e : listaEnemigos) {
            if (nave.Hitbox.intersects(e.enemigoRect)) {
                nave.vida -= 60;
            }
        }
        if (nave.vida < 0) {
            grafico.drawString("FIN DEL JUEGO", WIDHT / 2, HEIGHT / 2);
        }
        return grafico;
    }

    public void disparar(Rectangle misilRect) throws SlickException {

        for (Enemigo e : listaEnemigos) {
            if (misilRect.intersects(e.enemigoRect)) {
                e.vida-=nave.ataque;
                disparo=false;
                disparoDisponible = true;
                if(e.vida<=0){
                    puntuacion+=e.puntuacion;
                    listaEnemigosRemovidos.add(e);
                }
            }
        }
        for (Enemigo e : listaEnemigosRemovidos) {
            listaEnemigos.remove(e);
            
        }

    }
}
