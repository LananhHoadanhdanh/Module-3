import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculator", value = "/product")
public class ProductDiscountCalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String des = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        double percent = Double.parseDouble(request.getParameter("percent"));
        double discountAmount = price * percent * 0.01;
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Thong tin san pham: " + des);
        printWriter.println("Chiet khau san pham: " + discountAmount);
        printWriter.println("Gia sau khi chiet khau: " + (price + discountAmount));

    }
}
