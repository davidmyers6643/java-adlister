import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {

    private int count = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        if (req.getParameter("reset") != null) {
            count = 0;
            res.sendRedirect("/count");
            return;
        }

        PrintWriter out;
        try {
            out = res.getWriter();
            out.println("<h1>" + ++count + "</h1>");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}