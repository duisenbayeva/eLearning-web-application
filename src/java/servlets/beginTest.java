/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Test;
import interfaces.IDBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "beginTest", urlPatterns = {"/beginTest"})
public class beginTest extends HttpServlet {

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
            int c = Integer.parseInt(request.getParameter("complexity"));
            Long sid = (Long) request.getServletContext().getAttribute("sid");
            Long tid = (Long) request.getServletContext().getAttribute("tid");           
            List<Test> test = dbutils.getTestListOfTopic(sid, tid, c);
            Long testid = test.get(0).getId();            
            //out.println(testid);
            String testUrl = "C:\\Users\\asusa\\Documents\\NetBeansProjects\\elearning2\\src\\java\\servlets\\tests\\"+testid+".txt";
            //out.println(testUrl);
            BufferedReader reader;
            ArrayList<String> text = new ArrayList<>();
            ServletContext context = request.getServletContext();
            try {
                File f = new File(testUrl);
                reader = new BufferedReader(new FileReader(f));
                String str;                
                //ArrayList<ArrayList<String>> tes = new ArrayList<>();               
                while((str = reader.readLine()) != null){                                      
                    text.add(str);
                    //out.println(str);
                }
                for(int j=0; j< text.size(); j++){                    
                    out.println(text.get(j)+"<br>");
                }
              
                
             
                
                context.setAttribute("test", text);
                response.sendRedirect("localtest.jsp");
            }catch (IOException ex) {
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
