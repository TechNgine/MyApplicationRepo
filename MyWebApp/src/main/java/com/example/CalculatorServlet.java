package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operator = request.getParameter("operator");

        if (num1Str == null || num2Str == null || operator == null) {
            response.getWriter().println("<h3>Error: Missing input values</h3>");
            return;
        }

        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result;

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
                    if (num2 == 0) {
                        response.getWriter().println("<h3>Error: Division by zero</h3>");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    response.getWriter().println("<h3>Error: Invalid operator</h3>");
                    return;
            }

            response.getWriter().println("<h3>Result: " + result + "</h3>");
        } catch (NumberFormatException e) {
            response.getWriter().println("<h3>Error: Invalid number format</h3>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
