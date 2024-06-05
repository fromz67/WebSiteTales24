package sources.servlets;

import sources.entities.Tale;
import sources.database.InMemoryTales;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditTaleServlet")
public class EditTaleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int index = Integer.parseInt(request.getParameter("index"));
        String title = request.getParameter("title");
        String taleText = request.getParameter("taleText");
        int likes = Integer.parseInt(request.getParameter("likes"));

        Tale updatedTale = new Tale(title, likes, taleText);
        InMemoryTales.updateTale(index, updatedTale);

        response.sendRedirect("index.jsp");
    }
}
