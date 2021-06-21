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
import java.util.List;


@WebServlet("/api/personall")
public class PersonAllServlet extends HttpServlet {

    static List<Person> personList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List piople =  new PersonService().readAllPersons();

        Gson gson = new Gson();
        String employeeJsonString = gson.toJson(piople);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();

    }
}
