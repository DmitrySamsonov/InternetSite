package my.app.servlet;

import my.app.exception.PersonWebException;
import my.app.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePerson")
public class PersonUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updatePersonId = req.getParameter("updatePersonId");
        String updatePersonName = req.getParameter("updatePersonName");
        String updatePersonAgeText = req.getParameter("updatePersonAge");
        req.setAttribute("updatePersonId", updatePersonId);
        req.setAttribute("updatePersonName", updatePersonName);
        req.setAttribute("updatePersonAge", updatePersonAgeText);
        req.getRequestDispatcher("/updatePersonPage.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personIdString = req.getParameter("personId");
        String personName = req.getParameter("personName");
        String personAgeString = req.getParameter("personAge");

        try {
            new PersonService().updatePersonById(personIdString, personName, personAgeString);
            req.getRequestDispatcher("api/persons").forward(req, resp);
        } catch (PersonWebException e) {
            req.setAttribute("messageList", e.getMessageList());
            req.getRequestDispatcher("/updatePersonPage.jsp").forward(req, resp);
        }
    }
}