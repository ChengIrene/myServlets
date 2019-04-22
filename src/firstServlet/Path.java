package firstServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/*")
public class Path extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Path Servlet</title>");
        out.print("</head>");
        out.print("<body>");

        //如果在瀏覽器中輸入的URI為: http://localhost:8080/myServlets/servlet/path  看到的結果會是以下

        out.printf("%s<br>", request.getRequestURI());  // /myServlets/servlet/path
        out.printf("%s<br>", request.getContextPath());  // /myServlet
        out.printf("%s<br>", request.getServletPath());  // /servlet
        out.print(request.getPathInfo());  // /path
        out.print("</body>");
        out.print("</html>");

    }
}
