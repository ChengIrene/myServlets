package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@MultipartConfig(location = "c:/workspace")  // 設定location屬性
@WebServlet("/photo2")
public class Photo2 extends HttpServlet {
    private final Pattern fileNameRegex = Pattern.compile("filename=\"(.*)\"");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  //為了處理中文檔名
        Part photo = request.getPart("photo");
        String filename = getSubmittedFileName(photo);
        photo.write(filename);
    }

    private String getSubmittedFileName(Part part) {
        String header = part.getHeader("Content-Disposition");
        Matcher matcher = fileNameRegex.matcher(header);
        matcher.find();

        String filename = matcher.group(1);
        if (filename.contains("\\")) {
            return filename.substring(filename.lastIndexOf("\\") + 1);
        }

        return filename;
    }
}
