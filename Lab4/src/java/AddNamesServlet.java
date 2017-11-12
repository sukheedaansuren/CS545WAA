import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import names.Person;

@WebServlet(urlPatterns = {"/AddNamesServlet"})
public class AddNamesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if (request.getParameter("addKey") != null && request.getParameter("fname") != null 
                && request.getParameter("lname") != null) {
            if (session.getAttribute("names") == null)
                session.setAttribute("names", new HashMap());
            Map<String, Person> map = (Map<String, Person>) session.getAttribute("names");
            map.put(request.getParameter("addKey"), new Person(request.getParameter("fname"), 
                    request.getParameter("lname")));
            session.setAttribute("names", map);
        }
        response.sendRedirect("AllNamesServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
