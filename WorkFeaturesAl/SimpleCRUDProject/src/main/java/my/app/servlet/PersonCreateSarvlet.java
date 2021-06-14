package my.app.servlet;

import my.app.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//TODO: how to receive JSON in servlet?

@WebServlet("/api/person")
public class PersonCreateSarvlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id=  req.getParameter("id");
       String name=  req.getParameter("name");
       String age=  req.getParameter("age");

       Person person = new Person(Long.parseLong(id),name, Integer.parseInt(age));
       PersonListServlet.personList.add(person);
    }
}
