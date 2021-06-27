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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet ("/api/person/*")
public class PersonByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getPathInfo();
        String[] pathParts = info.split("/");
        String stringId = pathParts[1];
        long id = Long.parseLong(stringId);
        Person person1 = PersonListServlet.personList.stream().filter(person -> person.getId()==id)
                .findFirst()
                .orElse(null);


        String personJsonString = new Gson().toJson(person1);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(personJsonString);
        out.flush();


    }
}
