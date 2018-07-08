package juegocolisiones;

import AbstractFactory.AbstractFactory;
import AbstractFactory.FactoryProducer;
import Enemigos.Enemigo;
import Enemigos.FactoryEnemigos;
import Naves.Nave;
import PowerUps.PowerUp;
import game.Fin;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import modelo.Usuarios;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.*;

/**
 *
 * @author Cesar Rosales <00060917@uca.edu.sv>
 */
public class JuegoColision extends BasicGame {

    private boolean choque = false;
    private boolean finJuego = false;
    private boolean disparo = false;
    private boolean disparoDisponible = true;
    private Image misil;
    private Input entrada;
    Nave nave;
    Usuarios jugador;
    float misilX = 0, misilY = 0;
    final static int WIDHT = 900, HEIGHT = 600;
    int flagMov = 0;
    public int puntuacion = 0;
    AbstractFactory factory = FactoryProducer.getFactory("Naves");

    ArrayList<Enemigo> listaEnemigos = new ArrayList<>();
    ArrayList<Enemigo> listaEnemigosRemovidos = new ArrayList<>();
    ArrayList<PowerUp> listaPowerUps = new ArrayList<>();
    ArrayList<PowerUp> listaPowerUpsRemovidos = new ArrayList<>();
    private Image explosion;
    private SpriteSheet explosionSprite;
    private Animation explosionAnimation;
    private int contExplosion = 0;
    private ArrayList<ExplosionGraphic> listaExplosiones = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public JuegoColision(int nave, Usuarios u) {
        super("colisiones");
        this.nave = factory.getNave(nave);
        this.jugador = u;
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        misil = new Image("Img/Misil.png");
        entrada = gc.getInput();
        nave.Iniciar();
        explosion = new Image("Image/explosion sprite.png");
        explosionSprite = new SpriteSheet(explosion, 50, 50);
        explosionAnimation = new Animation(explosionSprite, 200);
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        actualizarNaveJugador();
        actualizarNaveEnemigos();
        spawnearEnemigos();
        spawnearPowerUps();
        activarPowerUp();
//        explosionAnimation.update(2000);
//        eliminar();

    }

    @Override
    public void render(GameContainer gc, Graphics grafico) throws SlickException {
        grafico.drawString("Salud: " + nave.vida, 20, HEIGHT - 40);
        grafico.drawString("Puntuacion: " + puntuacion, WIDHT - 150, HEIGHT - 40);
        nave.imagen.draw(nave.posicionX, nave.posicionY);
        //grafico.drawRect(nave.Hitbox.getX(), nave.Hitbox.getY(), nave.Hitbox.getWidth(), nave.Hitbox.getHeight());
        contExplosion++;
        eliminar();
        if (disparo) {
            misil.draw(misilX, misilY);
            Rectangle misilRect = new Rectangle(misilX, misilY, misil.getWidth(), misil.getHeight());
            //grafico.drawRect(misilRect.getX(), misilRect.getY(), misilRect.getWidth(), misilRect.getHeight());
            misilX += nave.velocidadBala;
            misilRect.setX(misilX);
            if (misilX >= WIDHT - 20) {
                disparoDisponible = true;
            }
            disparar(misilRect);
        }
        for (Enemigo e : listaEnemigos) {
            e.imagen.draw(e.posicionX, e.posicionY);
            //grafico.drawRect(e.enemigoRect.getX(), e.enemigoRect.getY(), e.enemigoRect.getWidth(), e.enemigoRect.getHeight());
        }
        for (PowerUp p : listaPowerUps) {
            p.imagen.draw(p.posicionX, p.posicionY);
            //grafico.drawRect(p.Hitbox.getX(), p.Hitbox.getY(), p.Hitbox.getWidth(), p.Hitbox.getHeight());
        }
        verificar(grafico);
        if (finJuego) {

        }
    }

    private void spawnearEnemigos() {
        double randomNum = ThreadLocalRandom.current().nextDouble(0, 100);
        int enemigo = 1;
        if (randomNum < 2) {
            AbstractFactory factory = FactoryProducer.getFactory("Enemigos");
            if (randomNum < 0.3) {
                enemigo = 2;
            }
            Enemigo enem = factory.getEnemigo(enemigo);
            int posicionBrandom = ThreadLocalRandom.current().nextInt(0, HEIGHT);
            enem.Iniciar(WIDHT);
            enem.posicionY = posicionBrandom;
            enem.enemigoRect.setY(enem.posicionY);
            for (Enemigo e : listaEnemigos) {
                if (enem.enemigoRect.intersects(e.enemigoRect)) {
                    return;
                }
            }
            for (PowerUp p : listaPowerUps) {
                if (enem.enemigoRect.intersects(p.Hitbox)) {
                    return;
                }
            }
            listaEnemigos.add(enem);
        }
    }

    private void spawnearPowerUps() {
        double randomNum = ThreadLocalRandom.current().nextDouble(0, 100);
        int powerUpEscogido = 0;
        if (randomNum < 0.5) {
            PowerUp power;
            AbstractFactory factory = FactoryProducer.getFactory("PowerUps");
            int powerBrandom = ThreadLocalRandom.current().nextInt(1, 3 + 1);
            switch (powerBrandom) {
                case 1:
                    powerUpEscogido = 1;
                    break;
                case 2:
                    powerUpEscogido = 2;
                    break;
                case 3:
                    powerUpEscogido = 3;
                    break;
            }
            power = factory.getPowerUp(powerUpEscogido);
            int posicionBrandom = ThreadLocalRandom.current().nextInt(0, HEIGHT);
            power.Iniciar(WIDHT);
            power.posicionY = posicionBrandom;
            power.Hitbox.setY(power.posicionY);
            for (Enemigo e : listaEnemigos) {
                if (power.Hitbox.intersects(e.enemigoRect)) {
                    return;
                }
            }
            for (PowerUp p : listaPowerUps) {
                if (power.Hitbox.intersects(p.Hitbox)) {
                    return;
                }
            }
            listaPowerUps.add(power);
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
        for (PowerUp p : listaPowerUps) {
            p.posicionX -= p.velocidad;
            p.Hitbox.setX(p.posicionX);
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
            finJuego = true;

        }
        return grafico;
    }
    private void activarPowerUp(){
        for(PowerUp p: listaPowerUps){
            if (nave.Hitbox.intersects(p.Hitbox)){
                nave.vida+=p.vidaExtra;
                nave.velocidad+=p.velocidadExtra;
                puntuacion+=p.puntuacionExtra;
                listaPowerUpsRemovidos.add(p);
            }
        }
        for (PowerUp p : listaPowerUpsRemovidos) {
            listaPowerUps.remove(p);
        }
    }

    public void disparar(Rectangle misilRect) throws SlickException {
        for (PowerUp p : listaPowerUps) {
            if (misilRect.intersects(p.Hitbox)) {
                disparo = false;
                disparoDisponible = true;
                listaPowerUpsRemovidos.add(p);
            }
        }
        for (PowerUp p : listaPowerUpsRemovidos) {
            listaPowerUps.remove(p);
        }
        for (Enemigo e : listaEnemigos) {
            if (misilRect.intersects(e.enemigoRect)) {
                e.vida -= nave.ataque;
                disparo = false;
                disparoDisponible = true;
                if (e.vida <= 0) {
                    puntuacion += e.puntuacion;
                    listaEnemigosRemovidos.add(e);
                    ExplosionGraphic explosion = new ExplosionGraphic();
                    explosion.drawAnimation(explosionAnimation, misilRect.getX(), misilRect.getY());
                    listaExplosiones.add(explosion);
                }
            }
        }
        for (Enemigo e : listaEnemigosRemovidos) {
            listaEnemigos.remove(e);

        }

    }

    public void eliminar() throws SlickException {
        if (contExplosion == 100) {
            for (int j = 0; j < listaExplosiones.size(); j++) {
                ExplosionGraphic obj = listaExplosiones.get(j);
                listaExplosiones.remove(j);

                obj = null;
            }
            contExplosion = 0;

        }
    }
}
