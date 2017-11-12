import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/GuessnumberServlet"})
public class GuessnumberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("guess") == null)
            session.setAttribute("guess", Math.round(Math.random()*10));
        
        if (request.getParameter("number") != null && !"".equals(request.getParameter("number"))) {
            long number = Long.parseLong(request.getParameter("number"));
            long numberSession = (Long) session.getAttribute("guess");
            if  (number == numberSession) {
                request.setAttribute("message", "Correct, congratulations!");
                session.setAttribute("guess", Math.round(Math.random()*10));
            } else if (number < numberSession) {
                request.setAttribute("message", "Too low, try again");
            } else {
                request.setAttribute("message", "Too high, try again");
            }
        }
       
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/guessnumber.jsp");
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
