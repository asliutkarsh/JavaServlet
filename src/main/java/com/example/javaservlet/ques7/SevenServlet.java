package com.example.javaservlet.ques7;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "SevenServlet", value = "/SevenServlet")
public class SevenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String principal= request.getParameter("principal");
        String rate= request.getParameter("rate");
        String time= request.getParameter("time");
        String choice = request.getParameter("choice");

        if (choice.equalsIgnoreCase("si")){
            RequestDispatcher rd = request.getRequestDispatcher("SIServlet");
            rd.forward(request,response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("CIServlet");
            rd.forward(request,response);
        }


    }
}
