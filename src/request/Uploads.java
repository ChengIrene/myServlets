package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.time.Instant;

@MultipartConfig(location = "c:/work")
@WebServlet("/uploads")
public class Uploads extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        request.getParts()
                .stream()  // 使用Stream
                .filter(part -> part.getName().startsWith("file"))  // 只處理上傳檔案的區段
                .forEach(this::write);
    }

    private void write(Part part) {
        String submittedFileName = part.getSubmittedFileName();
        String ext = submittedFileName.substring(  // 取得副檔名
                submittedFileName.lastIndexOf('.'));

        try {
            part.write(String.format("%s%s",  // 使用時間毫秒數為主檔名
                    Instant.now().toEpochMilli(), ext));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
