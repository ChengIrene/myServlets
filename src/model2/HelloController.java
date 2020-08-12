package model2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/helloController")
public class HelloController extends HttpServlet {

    private HelloModel model = new HelloModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("user");  //收集請求參數
        String message = model.doHello(name);  //委託HelloModel物件處理
        request.setAttribute("message", message);  //將結果訊息設定至請求物件成為屬性
        request.getRequestDispatcher("hello.view").forward(request, response);  //轉發給hello.view進行回應

    }
}
