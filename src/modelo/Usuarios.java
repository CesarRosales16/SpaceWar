/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Usuarios {

    private String Usuario;
    private String Password;
    private int PuntuacionMaxima;
    private int Leks;

    public Usuarios() {
    }

    public Usuarios(String Usuario, int PuntuacionMaxima) {
        this.Usuario = Usuario;
        this.PuntuacionMaxima = PuntuacionMaxima;
    }
    

    public Usuarios(String Usuario, String Password, int PuntuacionMaxima, int Leks) {
        this.Usuario = Usuario;
        this.Password = Password;
        this.PuntuacionMaxima = PuntuacionMaxima;
        this.Leks = Leks;
    }

    public Usuarios(String Usuario, String Password) {
        this.Usuario = Usuario;
        this.Password = Password;
    }
    

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getPuntuacionMaxima() {
        return PuntuacionMaxima;
    }

    public void setPuntuacionMaxima(int PuntuacionMaxima) {
        this.PuntuacionMaxima = PuntuacionMaxima;
    }

    public int getLeks() {
        return Leks;
    }

    public void setLeks(int Leks) {
        this.Leks = Leks;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "Usuario=" + Usuario + ", Password=" + Password + ", PuntuacionMaxima=" + PuntuacionMaxima + ", Leks=" + Leks + '}';
    }
    public String mostrarTop10(){
        return "Astronauta: "+Usuario+"  Puntuacion Maxima "+PuntuacionMaxima+" Puntos\n";
    }
    
    
}