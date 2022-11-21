package com.example.javaservlet.ques7;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CIServlet", value = "/CIServlet")
public class CIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Double principal= Double.parseDouble(request.getParameter("principal"));
        Double rate= Double.parseDouble(request.getParameter("rate"));
        Double time= Double.parseDouble(request.getParameter("time"));
        double total = principal*Math.pow((1+(rate/100)),time);
        double ci = total-principal;
        out.println("Compound Interest = "+ci +"</br></br>");
        out.println("Total Amount ="+total);
    }
}
