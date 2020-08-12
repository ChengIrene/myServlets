package exercises;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig
@WebServlet("/login")
public class ExerciseCh2_2 extends HttpServlet {

    String header =
            "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
                "<meta charset='UTF-8'>" +
                "<title>Login Result</title>" +
            "</head>" +
            "<body>";

    String footer =
            "</body>" +
            "</html>";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        out.printf(header);

        if("caterpillar".equals(username) && "123456".equals(password)) {
            out.print("<h1>Login successful</h1>");
        } else {
            out.printf("<h1>Login failed</h1><br>");
            out.printf("<a href='exerciseCh2_2.html'>Back to login form</a>");

        }

        out.printf(footer);
    }

}
