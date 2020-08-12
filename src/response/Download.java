package response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/download")
public class Download extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passwd = request.getParameter("passwd");

        if("123456".equals(passwd)) {

            response.setContentType("application/pdf");  //設定內容類型

            try(InputStream in = getServletContext().getResourceAsStream("/WEB-INF/jdbc.pdf");  //取得輸入串流
                OutputStream out = response.getOutputStream()) {  //取得輸出串流

                byte[] buffer = new byte[1024];
                int length = -1;
                while ((length = in.read(buffer)) != -1) {  //讀取PDF並輸出
                    out.write(buffer, 0, length);
                }
            }

        }

    }
}
