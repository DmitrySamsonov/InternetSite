package my.app.servlet;

import my.app.entity.Employee;
import my.app.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class EmployeeListServlet extends HttpServlet {

    static List<Employee> employeeList;


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

        List<Employee> people = new EmployeeService().readAllEmployees();
        HttpSession session = req.getSession(false);
        session.setAttribute("employeeList", people);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/employee.jsp");
    }
}

     /*   Gson gson = new Gson();



        String personJsonString = gson.toJson(personList);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(personJsonString);
        out.flush();
*/

