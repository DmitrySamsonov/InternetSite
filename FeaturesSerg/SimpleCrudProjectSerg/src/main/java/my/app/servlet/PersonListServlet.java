package my.app.servlet;

import com.google.gson.Gson;
import my.app.entity.Person;
import my.app.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonListServlet extends HttpServlet {

    static List<Person> personList;


  /*  @Override
  public void init() throws ServletException {
        personList = Stream.of(
                new Person(1, "Karan", 1000),
                new Person(1, "Karan", 2000),
                new Person(1, "Karan", 3000),
                new Person(1, "Karan", 4000)
        ).collect(Collectors.toList());
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();

        personList = Stream.of(
                new Person(1, "Karan", 5000),
                new Person(2, "Karan", 5000),
                new Person(3, "Karan", 5000)
        ).collect(Collectors.toList());

        String personJsonString = gson.toJson(personList);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(personJsonString);
        out.flush();
    }
}



    /*    List<Person> people = new PersonService().readAllPersons();
        HttpSession session = req.getSession(false);
        session.setAttribute("personList", people);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/person.jsp");
    }
}*/

       /* Gson gson = new Gson();

        Person employee = new Person(1, "Karan", 5000);

        String personJsonString = gson.toJson(employee);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(personJsonString);
        out.flush();
    }*/


