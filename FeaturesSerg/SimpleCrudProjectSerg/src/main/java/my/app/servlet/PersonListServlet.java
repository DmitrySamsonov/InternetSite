package my.app.servlet;

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


    @Override
  public void init() throws ServletException {
        personList = Stream.of(
                new Person(1, "Karan", 1000),
                new Person(1, "Karan", 2000),
                new Person(1, "Karan", 3000),
                new Person(1, "Karan", 4000)
        ).collect(Collectors.toList());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


     /*   Gson gson = new Gson();



        String personJsonString = gson.toJson(personList);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(personJsonString);
        out.flush();
*/
    }
}
