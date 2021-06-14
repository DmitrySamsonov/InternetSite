package my.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/persond/*")
public class PersonDeleteServlet extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String info = req.getPathInfo();
        String[] pathParts = info.split("/");
        String ids = pathParts[1];
        long id = Long.parseLong(ids);


//        String ids = req.getParameter("id");
//        long id = Long.parseLong(ids);
        PersonListServlet.personList.removeIf(person -> person.getId()==id);

    }
}
