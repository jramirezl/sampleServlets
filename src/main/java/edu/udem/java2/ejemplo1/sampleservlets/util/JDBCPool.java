/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udem.java2.ejemplo1.sampleservlets.util;

import edu.udem.java2.ejemplo1.sampleservlets.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author jpramirez
 */
public class JDBCPool {

    BasicDataSource ds = null;

    public void init() {
        ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:~/test");
        ds.setUsername("sa");
        ds.setPassword("sa");
        
    }
    
    public void destroy (){
        try {
            ds.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Persona obetenerPersona(String login, String password) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        Persona p = null;

        try {
            con = ds.getConnection();
            ps = con.prepareStatement("Select nombre, apellido, login, password, email "
                    + " from users where login = ?  and password = ? ");
            
            ps.setString(1, login);
            ps.setString(2, password);

            rs = ps.executeQuery();

            while (rs.next()) {
                p = new Persona();
                p.setApellido(rs.getString("apellido"));
                p.setNombre(rs.getString("nombre"));
                p.setEmail(rs.getString("email"));
                p.setLogin(rs.getString("login"));
                p.setPsw(rs.getString("password"));
            }

        } catch (Exception ex) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
                
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        return p;
    }
}
