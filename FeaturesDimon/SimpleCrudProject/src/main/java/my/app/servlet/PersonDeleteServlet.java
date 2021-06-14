package my.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/personDelete/*")
public class PersonDeleteServlet extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String stringId = pathParts[2];
        int id = Integer.parseInt(stringId);

//        String stringId = req.getParameter("id");
//        int id = Integer.parseInt(stringId);
        PersonListServlet.personList.removeIf(person -> person.getId() == id);
    }
}
