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
    private Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
        personList = Stream.of(
                new Person(1L, "Karan", 50),
                new Person(2L, "Karan2", 55),
                new Person(3L, "Karan6", 60),
                new Person(99L, "Karan478", 70)
        ).collect(Collectors.toList());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("ty-ty-ty la--la-la");

//        personList = Stream.of(
//                new Person(1L, "Karan", 50),
//                new Person(2L, "Karan2", 55),
//                new Person(3L, "Karan6", 60),
//                new Person(99L, "Karan478", 70)
//        ).collect(Collectors.toList());


        String employeeJsonString = this.gson.toJson(personList);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }

}

