package my.app.servlet;

import com.google.gson.Gson;
import my.app.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/person/*")
public class PersonByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String stringId = pathParts[2];
        int id = Integer.parseInt(stringId);

         Person person1 = PersonListServlet.personList.stream().filter(person -> person.getId() ==id)
                .findFirst()
                .orElse(null);

        String employeeJsonString = new Gson().toJson(person1);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }


}
