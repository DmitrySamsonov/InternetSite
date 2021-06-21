package my.app.servlet;

import my.app.exception.EmployeeWebException;
import my.app.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPerson")
public class EmployeeAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String personName = req.getParameter("personName");
        String personAgeString = req.getParameter("personAge");

        try {
            new EmployeeService().createPerson(personName, personAgeString);
            req.getRequestDispatcher("api/persons").forward(req, resp);
        } catch (EmployeeWebException e) {
            req.setAttribute("messageList", e.getMessageList());
            req.getRequestDispatcher("/addEmployee.jsp").forward(req, resp);
        }

    }

}



