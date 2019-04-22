package firstServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "HelloServlet",  //servlet的名稱是Hello
        urlPatterns = {"/hello"},  //瀏覽器請求的URI是/hello
        loadOnStartup = 1  //預設值為-1,設定大於0的值,表示啟動應用程式後救初始化Servlet,數字代表初始順序
)
public class Hello extends HttpServlet {  //繼承HttpServlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override  //重新定義doGet()
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");  //取得請求參數

        PrintWriter out = response.getWriter();  //取得回應輸出物件
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Hello</title>");
        out.print("</head>");
        out.print("<body>");
        out.printf("<h1>Hello! %s!%n</h1>", name);  //跟使用者說Hello!
        out.print("</body>");
        out.print("</html>");

    }
}
