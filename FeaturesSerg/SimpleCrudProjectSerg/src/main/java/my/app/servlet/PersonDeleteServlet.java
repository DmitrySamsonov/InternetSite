package my.app.servlet;

import my.app.exception.PersonWebException;
import my.app.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/personDelete")
public class PersonDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deletePersonIdString = req.getParameter("deletePersonId");
        int deletePersonId = Integer.parseInt(deletePersonIdString);


        try {
            new PersonService().deletePersonById(deletePersonId);
            req.getRequestDispatcher("persons").forward(req, resp);
        } catch (PersonWebException e) {
            req.setAttribute("messageList", e.getMessageList());
            req.getRequestDispatcher("/Person.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringId = req.getParameter("id");
        int id = Integer.parseInt(stringId);
        PersonListServlet.personList.removeIf(person -> person.getId() == id);
    }


}
