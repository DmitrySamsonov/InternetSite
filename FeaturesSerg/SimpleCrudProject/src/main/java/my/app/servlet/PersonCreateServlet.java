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

@WebServlet("/api/person")
public class PersonCreateServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();

        List<Person> personList = Stream.of(
                new Person(1, "Karan", 1000),
                new Person(1, "Karan", 2000),
                new Person(1, "Karan", 3000),
                new Person(1, "Karan", 4000)

        ).collect(Collectors.toList());


        String personJsonString = gson.toJson(personList);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(personJsonString);
        out.flush();

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        String name= req.getParameter("name");
        String ageString = req.getParameter("age");

        Person person = new Person(Long.parseLong(idString), name, Integer.parseInt(ageString));

    }
}
