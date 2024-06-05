package sources.servlets;

import sources.entities.Tale;
import sources.database.InMemoryTales;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddTaleServlet")
public class AddTaleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String taleText = request.getParameter("taleText");
        int likes = Integer.parseInt(request.getParameter("likes"));

        Tale newTale = new Tale(title, likes, taleText);
        InMemoryTales.addTale(newTale);

        response.sendRedirect("index.jsp");
    }
}
