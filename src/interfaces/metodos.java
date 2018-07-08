/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.Usuarios;

/**
 *
 * @author LN710Q
 */
public interface metodos <Generic>{
    public boolean create(Generic g);
    public boolean delete (Object key);
    public boolean updatePassword (Generic c);
    public boolean updateLeks (int precio, Usuarios u);
    
    public Generic read(Object key);
    public ArrayList<Generic> readAll();
    public ArrayList<Generic> readTop10();
    
}
