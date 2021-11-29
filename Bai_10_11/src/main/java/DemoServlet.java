import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoServlet", value = "/demo")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("demo.jsp");
//        String name = request.getParameter("xxx");
//        request.setAttribute("yyy", name);
//        requestDispatcher.forward(request, response);

        RequestDispatcher requestDispatcher;
        String path;
        String hanhDong = request.getParameter("action");
        switch (hanhDong) {
            case "about" :
                path = "about.jsp";
                break;
            case "contact" :
                path = "contact.jsp";
                break;
            default:
                path = "demo.jsp";
        }
        requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
