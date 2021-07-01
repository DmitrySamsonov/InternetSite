package my.den.app.servlet;

import com.google.gson.Gson;
import my.den.app.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * В классе EmployeeService (если нету - создать), который лежит в пакете good.team.service (если нету - создать),
 * создать метод updateEmployee по обновлению employee по Id.
 * метод updateEmployee() будет использовать метод updateEmployee() из класса EmployeeJdbcDao
 * (если нету - создать болванку\обертку\пустой метод).
 * Входные параметры:
 * Employee employee  - чувак со старым id и обновленными (возможно не всеми) полями
 */

@WebServlet("/api/updatepersonbyid/*")
public class PersonUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String stringId = req.getParameter("id");
//        long id = Long.parseLong(stringId);

        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String stringId = pathParts[1];
//        long id = 1;
        long id = Long.parseLong(stringId);
        String name = req.getParameter("name");
        String ageString = req.getParameter("age");
        new PersonService().updatePersonById(id,name,ageString);

        Gson gson = new Gson();
        String personJsonString = gson.toJson("person update");

        PrintWriter out = resp.getWriter();
        out.print(personJsonString);
        out.flush();
    }
}

