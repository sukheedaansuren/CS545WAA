import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import names.Person;

@WebServlet(urlPatterns = {"/AllNamesServlet"})
public class AllNamesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // show names list
        Map<String, Person> names;
        HttpSession session = request.getSession(true);
        StringBuilder sb = new StringBuilder();
        if (session.getAttribute("names") == null) names = new HashMap();
        else names = (Map<String, Person>) session.getAttribute("names");
        for(String key : names.keySet()) {
            sb.append(String.format("Key=%s first name=%s last name=%s<br>", 
                    key, names.get(key).getFname(), names.get(key).getLname()));
        }
        System.out.println(sb.toString());
        request.setAttribute("message", sb.toString());
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/names.jsp");
        dispatcher.forward(request,response);
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
