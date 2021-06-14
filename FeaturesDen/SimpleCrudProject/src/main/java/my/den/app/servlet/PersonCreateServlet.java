package my.den.app.servlet;

import com.google.gson.Gson;
import my.den.app.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/person")
public class PersonCreateServlet extends HttpServlet {

    {
        System.out.println();
    }


    public PersonCreateServlet() {
        System.out.println();
    }

    @Override
    public void init() throws ServletException {
        System.out.println();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idString = req.getParameter("id");
        String name = req.getParameter("name");
        String ageString = req.getParameter("age");

        Person person = new Person(Long.parseLong(idString),name,Integer.parseInt(ageString));
        PersonListServlet.personList.add(person);

        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        PrintWriter out = resp.getWriter();
        out.print(personJsonString);
        out.flush();


    }


}
