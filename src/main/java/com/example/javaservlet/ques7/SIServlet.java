package com.example.javaservlet.ques7;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SIServlet", value = "/SIServlet")
public class SIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Double principal= Double.parseDouble(request.getParameter("principal"));
        Double rate= Double.parseDouble(request.getParameter("rate"));
        Double time= Double.parseDouble(request.getParameter("time"));
        double si = (principal*rate*time)/100;
        double total = principal+si;
        out.println("Simple Interest = "+si +"</br></br>");
        out.println("Total Amount ="+total);
    }
}
