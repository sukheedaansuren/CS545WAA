/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import names.Person;

/**
 *
 * @author Khandaa
 */
@WebServlet(urlPatterns = {"/AllNamesServlet"})
public class AllNamesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        
        // show names list
        Map<String, Person> names;
        HttpSession session = request.getSession(true);
        if (session.getAttribute("names") == null) names = new HashMap();
        else names = (Map<String, Person>) session.getAttribute("names");
        for(String key : names.keySet()) {
            out.println(String.format("Key=%s first name=%s last name=%s<br>", 
                    key, names.get(key).getFname(), names.get(key).getLname()));
        }
        // form
        out.println("<a href='AllNamesServlet'><input type=button value='Show all names'></a><br><br>");
        out.println("<form method=POST action=AddNamesServlet>");
        out.println("Key=<input type=text name=addKey pattern='\\d'>");
        out.println("First Name=<input type=text name=fname required>");
        out.println("Last Name=<input type=text name=lname required>");
        out.println("<input type=submit value='Add'><br><br>");
        out.println("</form>");
        
        out.println("<form method=POST action=RemoveNamesServlet>");
        out.println("Key=<input type=text name=removeKey pattern='\\d'>");
        out.println("<input type=submit value='Remove'>");
        out.println("</form>");
                
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
