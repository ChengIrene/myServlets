package response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/pet")
public class Pet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  //設定請求物件字元編碼
        response.setContentType("text/html; charset=UTF-8");  //設定內容類型

        PrintWriter out = response.getWriter();  //取得輸出物件
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");

        out.printf("Contact person: <a href='mailto:%s'> %s </a><br> %n",
                request.getParameter("email"),
                request.getParameter("user")
        );

        out.println("<br>Your favorite pet");
        out.println("<ul>");

        Arrays.asList(request.getParameterValues("type"))
                .forEach(type -> out.printf("<li> %s </li> %n", type));

        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");

    }
}
