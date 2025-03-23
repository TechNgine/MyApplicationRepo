package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operator = request.getParameter("operator");

        if (num1Str == null || num2Str == null || operator == null) {
            response.getWriter().println("<h3>Invalid input</h3>");
            return;
        }

        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        response.getWriter().println("<h3>Error: Division by zero</h3>");
                        return;
                    }
                    break;
                default:
                    response.getWriter().println("<h3>Invalid operator</h3>");
                    return;
            }

            response.getWriter().println("<h3>Result: " + result + "</h3>");
        } catch (NumberFormatException e) {
            response.getWriter().println("<h3>Invalid number format</h3>");
        }
    }
}
