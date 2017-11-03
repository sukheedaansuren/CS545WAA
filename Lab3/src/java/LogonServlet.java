import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Khandaa
 */
@WebServlet(urlPatterns = {"/LogonServlet"})
public class LogonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        
        if ("khandaa".equals(request.getParameter("username")) 
                && "123".equals(request.getParameter("password"))) {
            out.println("Welcome user");
        } else {
            if (!"".equals(request.getParameter("username")) || !"".equals(request.getParameter("password"))) {
                out.println("Wrong userid or password! please try again<br>");
            }
            out.println("<form method=GET action=LogonServlet>");
            out.println("Username=<input type=text name=username> <br>");
            out.println("Password=<input type=text name=password>");
            out.println("<input type=submit value='Logon'>");
            out.println("</form>");
        }
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
