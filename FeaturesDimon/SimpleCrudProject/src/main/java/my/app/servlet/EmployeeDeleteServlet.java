package my.app.servlet;

import my.app.exception.EmployeeWebException;
import my.app.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/personDelete")
public class EmployeeDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deletePersonIdString = req.getParameter("deletePersonId");
        int deletePersonId = Integer.parseInt(deletePersonIdString);


        try {
            new EmployeeService().deletePersonById(deletePersonId);
            req.getRequestDispatcher("persons").forward(req, resp);
        } catch (EmployeeWebException e) {
            req.setAttribute("messageList", e.getMessageList());
            req.getRequestDispatcher("/Person.jsp").forward(req, resp);
        }


    }
}
