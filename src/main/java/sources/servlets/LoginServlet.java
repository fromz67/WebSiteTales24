package sources.servlets;

import sources.entities.User;
import sources.database.InMemoryUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private InMemoryUser userManager;

    @Override
    public void init() throws ServletException {
        userManager = new InMemoryUser();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User loggedInUser = userManager.getUserByCredentials(login, password);

        if (loggedInUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userType", loggedInUser.getUserType());
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?error=true&login=&password=");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
