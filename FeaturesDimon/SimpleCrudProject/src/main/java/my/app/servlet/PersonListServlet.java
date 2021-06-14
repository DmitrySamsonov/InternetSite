package my.app.servlet;

import com.google.gson.Gson;
import my.app.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet
public class PersonListServlet extends HttpServlet {

    static List<Person> personList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.getWriter().println("text");

        Gson gson = new Gson();

        personList = Stream.of(new Person(1, "Slava", 35),
                new Person(2, "Dima", 20),
                new Person(3, "Egor", 11),
                new Person(4, "Misha", 44)).collect(Collectors.toList());

//        Person employee = new Person(1, "Slava", 35);
        String employeeJsonString = gson.toJson(personList);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();


    }
}
