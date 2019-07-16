/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udem.java2.ejemplo1.sampleservlets;

import edu.udem.java2.ejemplo1.sampleservlets.util.JDBCPool;
import edu.udem.java2.ejemplo1.sampleservlets.util.JDBCUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpramirez
 */
public class LoginServlet extends HttpServlet {

    Map<String, Persona> usersMap;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        usersMap = new HashMap<>();
        usersMap.put("jsmith", new Persona("Smith", "Jhon", "jsmith", "123"));
        usersMap.put("mperez", new Persona("Perez", "Mary", "mperez", "456"));

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
        
        
        JDBCPool bCPool=  (JDBCPool)request.getSession().getServletContext().getAttribute("pool");
        Persona persona = null;

        if ((login != null && login.length() > 0) && (pwd != null && pwd.length() > 0)) {
            persona = bCPool.obetenerPersona(login, pwd);
        }

        if (persona != null) {

            request.setAttribute("message", "Bienvenido " + persona.getNombre() + " " + persona.getApellido());
            RequestDispatcher dispacher = request.getRequestDispatcher("/welcome.jsp");
            dispacher.forward(request, response);
        } else {
            RequestDispatcher dispacher = request.getRequestDispatcher("/login.jsp");
            dispacher.forward(request, response);
        }
    }

}
