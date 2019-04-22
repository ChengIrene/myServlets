package firstServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Mapping", urlPatterns = "/mapping/*")
public class Mapping extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpServletMapping mapping = request.getHttpServletMapping();
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Mapping Servlet</title>");
        out.print("<body>");
        out.printf("%s<br>", mapping.getMappingMatch());  // PATH
        out.printf("%s<br>", mapping.getMatchValue());  // path
        out.print(mapping.getPattern());  // /mapping/*
        out.print("</body>");
        out.print("</html>");

    }
}
