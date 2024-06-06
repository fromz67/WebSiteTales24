import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import sources.entities.Tale;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");
        
        List<Tale> searchResults = searchTales(query);
        
        request.setAttribute("searchResults", searchResults);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private List<Tale> searchTales(String query) {
        List<Tale> allTales = getTalesFromDataSource();
        List<Tale> searchResults = new ArrayList<>();

        for (Tale tale : allTales) {
            if (tale.getTitle().toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(tale);
            }
        }
        return searchResults;
    }

    private List<Tale> getTalesFromDataSource() {
        List<Tale> tales = new ArrayList<>();
        return tales;
    }
}
