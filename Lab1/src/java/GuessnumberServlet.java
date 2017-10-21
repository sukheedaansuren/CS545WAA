/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khandaa
 */
@WebServlet(urlPatterns = {"/GuessnumberServlet"})
public class GuessnumberServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GuessnumberServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GuessnumberServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        HttpSession session = request.getSession();
        if (session.getAttribute("guess") == null)
                //|| Long.parseLong((String) session.getAttribute("number")) == 0L) 
            session.setAttribute("guess", Math.round(Math.random()*10));
        
        if (request.getParameter("number") != null && !"".equals(request.getParameter("number"))) {
            long number = Long.parseLong(request.getParameter("number"));
            long numberSession = (Long) session.getAttribute("guess");
            if  (number == numberSession) {
                out.println("Correct, congratulations!");
                session.setAttribute("guess", Math.round(Math.random()*10));
            } else if (number < numberSession) {
                out.println("Too low, try again");
            } else {
                out.println("Too high, try again");
            }
        }
        out.println("Guess the number!<br>");
        out.println("<form method=GET action=GuessnumberServlet>");
        out.println("Number=<input type=text name=number pattern='\\d'> <br>");
        out.println("<input type=submit value='Guess'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
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
