/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

//import com.sun.istack.internal.logging.Logger;
import conexion.Conexion;
import interfaces.metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuarios;

/**
 *
 * @author LN710Q
 */
public class UsuariosDao implements metodos<Usuarios> {

    private static final String SQL_INSERT = "INSERT INTO Usuarios (Usuario, Password, PuntuacionMaxima, Leks) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Usuarios SET Password = ? WHERE usuario = ?";
    private static final String SQL_UPDATELEKS = "UPDATE Usuarios SET Leks = Leks-? WHERE usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE usuario = ?";
    private static final String SQL_READ = "SELECT * FROM usuarios WHERE usuario = ?";
    private static final String SQL_READALL = "SELECT * FROM usuarios";
    private static final String SQL_READTOP10 = "SELECT `Usuario`, `PuntuacionMaxima` FROM `usuarios` ORDER BY PuntuacionMaxima DESC limit 10";
    private static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(Usuarios u) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getPassword());
            ps.setInt(3, u.getPuntuacionMaxima());
            ps.setInt(4, u.getLeks());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean updatePassword(Usuarios u) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setString(1, u.getPassword());
            ps.setString(2, u.getUsuario());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }
    @Override
    public boolean updateLeks(int precio, Usuarios u) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_UPDATELEKS);
            ps.setInt(1, precio);
            ps.setString(2, u.getUsuario());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public Usuarios read(Object key) {
        Usuarios u = null;
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                u = new Usuarios(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return u;

    }

    @Override
    public ArrayList<Usuarios> readAll() {
        ArrayList<Usuarios> all = new ArrayList();
        Statement s;
        ResultSet rs;

        try {
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);

            while (rs.next()) {
                all.add(new Usuarios(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
    @Override
    public ArrayList<Usuarios> readTop10() {
        ArrayList<Usuarios> all = new ArrayList();
        Statement s;
        ResultSet rs;

        try {
            s = con.getCnx().prepareStatement(SQL_READTOP10);
            rs = s.executeQuery(SQL_READTOP10);

            while (rs.next()) {
                all.add(new Usuarios(rs.getString(1), rs.getInt(2)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }

}
