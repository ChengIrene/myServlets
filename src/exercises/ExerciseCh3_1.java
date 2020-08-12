package exercises;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/yourbook")
public class ExerciseCh3_1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("image.jpeg");
        ImageIO.write(getImage(request.getParameter("name")), "JPG", response.getOutputStream());
        //write(RenderedImage im, String formatName, OutputStream output)
    }

    public BufferedImage getImage(String name) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(getServletContext().getResourceAsStream("WEB-INF/book.jpg"));
        Graphics g = bufferedImage.getGraphics();
        g.setColor(Color.BLACK);
        g.setFont(new Font("標楷體", Font.BOLD, 25));
        //Font(String name, int style, int size)

        g.drawString(name, 15, 45);

        return bufferedImage;
    }

}
