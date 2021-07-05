package my.den.app.servlet;

import com.google.gson.Gson;
import my.den.app.entity.Person;
import my.den.app.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/person/*")
public class PersonByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String stringId = pathParts[1];
//        long id = 1;
        long id = Long.parseLong(stringId);
        Person person1 = PersonAllServlet.personList.stream().filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
//        Person person1 = PersonListServlet.personList.stream().filter(person -> person.getId() == id)
//                .findFirst()
//                .orElse(null);

        Gson gson = new Gson();
        String personJsonString = gson.toJson(new PersonService().readPersonById(id));

        PrintWriter out = resp.getWriter();
        out.print(personJsonString);
        out.flush();


    }
}
