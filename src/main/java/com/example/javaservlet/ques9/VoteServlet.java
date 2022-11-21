package com.example.javaservlet.ques9;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VoteServlet", value = "/VoteServlet")
public class VoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String choice = request.getParameter("choice");
        if (choice.equalsIgnoreCase("nm")){
            out.println("You Voted For Narendra Modi");
        } else if (choice.equalsIgnoreCase("rh")) {
            out.println("You Voted For Rahul Gandhi");
        }else {
            out.println("You didn't voted for anyone");
        }
    }
}
