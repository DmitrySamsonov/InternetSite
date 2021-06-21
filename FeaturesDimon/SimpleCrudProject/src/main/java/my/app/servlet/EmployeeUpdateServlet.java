package my.app.servlet;

import my.app.exception.EmployeeWebException;
import my.app.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateEmployee")
public class EmployeeUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String updateEmployeeId = req.getParameter("updateEmployeeId");
        String updateEmployeeName = req.getParameter("updateEmployeeName");
        String updateEmployeeAgeText = req.getParameter("updateEmployeeAge");
        req.setAttribute("updateEmployeeId", updateEmployeeId);
        req.setAttribute("updateEmployeeName", updateEmployeeName);
        req.setAttribute("updateEmployeeAge", updateEmployeeAgeText);
        req.getRequestDispatcher("/updateEmployeePage.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeIdString = req.getParameter("employeeId");
        String employeeName = req.getParameter("employeeName");
        String employeeAgeString = req.getParameter("employeeAge");

        try {
            new EmployeeService().updateEmployeeById(employeeIdString, employeeName, employeeAgeString);
            req.getRequestDispatcher("api/employees").forward(req, resp);
        } catch (EmployeeWebException e) {
            req.setAttribute("messageList", e.getMessageList());
            req.getRequestDispatcher("/updateEmployeePage.jsp").forward(req, resp);
        }
    }
}
