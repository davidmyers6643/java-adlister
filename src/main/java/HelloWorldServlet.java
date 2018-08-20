import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;



@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter out = null;
        String name = (req.getParameter("name") != null) ? req.getParameter("name" ) : "World";

         try {
             out = res.getWriter();
             out.printf("<h1>Hello, %s!<h1>", name);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}

