import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowFormServlet", urlPatterns = "/register")
public class ShowFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        String html = "<form method=\"POST\" action=\"/register\">\n" +
                "    <label for=\"email\">Email:</label>\n" +
                "    <input id=\"email\" name=\"email\" placeholder=\"Enter your email address\" />\n" +
                "</form>";
        PrintWriter printer = res.getWriter();
        printer.println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("email submitted: " + req.getParameter("email"));
        resp.sendRedirect("/bye");
    }
}
