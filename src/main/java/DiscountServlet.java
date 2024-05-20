import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", urlPatterns = "/LoginServlet")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        String prices = req.getParameter("price");
        String discountStr =req.getParameter("discount_percent");
        double price = Double.parseDouble(prices);
        double discount = Double.parseDouble(discountStr);
        double discountAmount = price * discount /100;
        double discountPrice = price - discountAmount;

        req.setAttribute("description", description);
        req.setAttribute("price", price);
        req.setAttribute("discount", discount);
        req.setAttribute("discountAmount", discountAmount);
        req.setAttribute("discountPrice", discountPrice);
        RequestDispatcher dispatcher = req.getRequestDispatcher("display-discount.jsp");
        dispatcher.forward(req, resp);
    }
}
