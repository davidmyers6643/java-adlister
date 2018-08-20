import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SayGoodbyeServlet", urlPatterns = "/bye")
public class SayGoodbyeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String filterVar = req.getParameter("filter");
        Double priceVar = Double.parseDouble(req.getParameter("price"));

        priceVar += 1;

        PrintWriter printer = res.getWriter();
        printer.println("New price: "+ priceVar);
        printer.println("selected filter: " + filterVar);
        printer.println("Bye bye");
    }

}
