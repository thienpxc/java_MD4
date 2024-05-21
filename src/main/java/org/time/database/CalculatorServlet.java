package org.time.database;

import org.time.model.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "calculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double operand1 = Double.parseDouble(req.getParameter("operand1"));
        double operand2 = Double.parseDouble(req.getParameter("operand2"));
        char operator = req.getParameter("operator").charAt(0);
        Calculator calculator = new Calculator();
        try {
            double result = calculator.calculate(operand1, operand2, operator);
            req.setAttribute("result", result);
        } catch (ArithmeticException e) {
            req.setAttribute("error", e.getMessage());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("calculator.jsp");
        dispatcher.forward(req, resp);
    }
}
