package my.den.app.servlet;

import my.den.app.entity.Person;
import my.den.app.servlet.PersonListServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/person/*")
public class PersonByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String stringId = pathParts[1];
//        long id = 1;
        long id = Long.parseLong(stringId);
        Person person1 = PersonListServlet.personList.stream().filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);

    }
}
