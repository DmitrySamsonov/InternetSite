package my.app.servlet;

import my.app.exception.PersonWebException;
import my.app.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPerson")
public class PersonAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addPerson.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String personName = req.getParameter("personName");
        String personAgeString = req.getParameter("personAge");

        try {
            new PersonService().createPerson(personName, personAgeString);
            req.getRequestDispatcher("api/persons").forward(req, resp);
        } catch (PersonWebException e) {
            req.setAttribute("messageList", e.getMessageList());
            req.getRequestDispatcher("/addPerson.jsp").forward(req, resp);
        }

    }

}



