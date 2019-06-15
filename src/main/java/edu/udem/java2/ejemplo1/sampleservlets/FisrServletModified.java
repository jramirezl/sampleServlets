/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.udem.java2.ejemplo1.sampleservlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jpramirez
 */
public class FisrServletModified extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"<style>\n" +
"body {\n" +
"  font-family: Arial, Helvetica, sans-serif;\n" +
"  background-color: black;\n" +
"}\n" +
"\n" +
"* {\n" +
"  box-sizing: border-box;\n" +
"}\n" +
"\n" +
"/* Add padding to containers */\n" +
".container {\n" +
"  padding: 16px;\n" +
"  background-color: white;\n" +
"}\n" +
"\n" +
"/* Full-width input fields */\n" +
"input[type=text], input[type=password] {\n" +
"  width: 100%;\n" +
"  padding: 15px;\n" +
"  margin: 5px 0 22px 0;\n" +
"  display: inline-block;\n" +
"  border: none;\n" +
"  background: #f1f1f1;\n" +
"}\n" +
"\n" +
"input[type=text]:focus, input[type=password]:focus {\n" +
"  background-color: #ddd;\n" +
"  outline: none;\n" +
"}\n" +
"\n" +
"/* Overwrite default styles of hr */\n" +
"hr {\n" +
"  border: 1px solid #f1f1f1;\n" +
"  margin-bottom: 25px;\n" +
"}\n" +
"\n" +
"/* Set a style for the submit button */\n" +
".registerbtn {\n" +
"  background-color: #4CAF50;\n" +
"  color: white;\n" +
"  padding: 16px 20px;\n" +
"  margin: 8px 0;\n" +
"  border: none;\n" +
"  cursor: pointer;\n" +
"  width: 100%;\n" +
"  opacity: 0.9;\n" +
"}\n" +
"\n" +
".registerbtn:hover {\n" +
"  opacity: 1;\n" +
"}\n" +
"\n" +
"/* Add a blue text color to links */\n" +
"a {\n" +
"  color: dodgerblue;\n" +
"}\n" +
"\n" +
"/* Set a grey background color and center the text of the \"sign in\" section */\n" +
".signin {\n" +
"  background-color: #f1f1f1;\n" +
"  text-align: center;\n" +
"}\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<form action=\"FisrServletModified\" method=\"POST\">\n" +
"  <div class=\"container\">\n" +
"    <h1>Registrar</h1>\n" +
"    <p>Favor ingresar los campos para registrar la cuenta.</p>\n" +
"    <hr>\n" +
"    \n" +
"    <label for=\"fName\"><b>Nombre</b></label>\n" +
"    <input type=\"text\" placeholder=\"Ingrese Nombre\" name=\"fName\" required>\n" +
"    \n" +
"    <label for=\"lName\"><b>Apellido</b></label>\n" +
"    <input type=\"text\" placeholder=\"Ingrese Appellido\" name=\"lName\" required>\n" +
"\n" +
"    <label for=\"email\"><b>Login</b></label>\n" +
"    <input type=\"text\" placeholder=\"Ingrese Login\" name=\"login\" required>\n" +
"\n" +
"    <label for=\"psw\"><b>Password</b></label>\n" +
"    <input type=\"password\" placeholder=\"Ingrese Password\" name=\"psw\" required>\n" +
"\n" +
"    <label for=\"psw-repeat\"><b>Repeat Password</b></label>\n" +
"    <input type=\"password\" placeholder=\"Ingrese Password\" name=\"psw-repeat\" required>\n" +
"    <hr>\n" +
"\n" +
"\n" +
"    <button type=\"submit\" class=\"registerbtn\">Guardar</button>\n" +
"  </div>\n" +
"  \n" +
"  <div class=\"container signin\">\n" +
"    <p>Ya creaste tu cuenta? <a href=\"#\">Sign in</a>.</p>\n" +
"  </div>\n" +
"</form>\n" +
"\n" +
"</body>");
        }
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
        //processRequest(request, response);
        System.out.println(request.getParameter("login"));
        System.out.println(request.getParameter("psw"));
        System.out.println(request.getParameter("lName"));
        
        Persona p = new Persona();
        p.setApellido(request.getParameter("lName"));
        p.setNombre(request.getParameter("fName"));
        p.setLogin(request.getParameter("login"));
        p.setPsw(request.getParameter("psw"));
        
        String personaJsonString = new Gson().toJson(p);
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(personaJsonString);
        out.flush();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
