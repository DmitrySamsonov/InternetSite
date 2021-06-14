package my.app.servlet;

import com.google.gson.Gson;
import my.app.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonListServlet extends HttpServlet {

    static List<Person> personList;

    static {
        personList = Stream.of(
                new Person(1L, "Karan", 1000),
                new Person(2L, "Karan", 2000),
                new Person(3L, "Karan", 3000),
                new Person(4L, "Karan", 4000)
        ).collect(Collectors.toList());
    }

    {
        System.out.println();
    }

    public PersonListServlet() {
        System.out.println();
    }

    @Override
    public void init() throws ServletException {
        System.out.println();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();
        String employeeJsonString = gson.toJson(personList);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();

    }
}
