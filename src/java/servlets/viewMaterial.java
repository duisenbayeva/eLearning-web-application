/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Topic;
import interfaces.IDBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asusa
 */
@WebServlet(name = "viewMaterial", urlPatterns = {"/viewMaterial"})
public class viewMaterial extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    IDBConnection dbutils;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Long id = Long.parseLong(request.getParameter("tid"));
            Long sid = Long.parseLong(request.getParameter("sid"));
            out.println(id);
            String name = dbutils.getTopic(id).getName();
            Topic topic = dbutils.getTopic(id);
            out.println(name);
            //String videoUrl = dbutils.getTopic(id).getVideoUrl();
            String fileUrl = "C:\\Users\\bduis_000\\Documents\\NetBeansProjects\\WebUser\\src\\java\\servlets\\materials\\"+name+".txt";
            BufferedReader reader;
            ArrayList<String> text = new ArrayList<>();
            ServletContext c = request.getServletContext();
            try {
                File f = new File(fileUrl);
                reader = new BufferedReader(new FileReader(f));
                String str;
                while ((str = reader.readLine()) != null) {
                    text.add(str);
                    out.println(str);
                }
                c.setAttribute("text", text);
                c.setAttribute("name", name);
                c.setAttribute("sid", sid);
                c.setAttribute("tid", id);
                c.setAttribute("videourl", topic.getVideoUrl());
                //out.println(request.getServletContext().getAttribute("videourl"));
                response.sendRedirect("subjectpage.jsp?sid="+sid);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            

        }
    }
    

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
        processRequest(request, response);
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
        processRequest(request, response);
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
