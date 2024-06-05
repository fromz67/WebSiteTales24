package sources.servlets;

import sources.database.InMemoryTales;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = (String) request.getSession().getAttribute("userType");
        if (user == null || user.equals("Гість")) {
            response.sendRedirect("login.jsp");
            return;
        }

        int index = Integer.parseInt(request.getParameter("index"));
        InMemoryTales.likeTale(index, user);

        response.sendRedirect("index.jsp");
    }
}
