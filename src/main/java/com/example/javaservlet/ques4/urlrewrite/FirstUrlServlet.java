package com.example.javaservlet.ques4.urlrewrite;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstUrlServlet", value = "/FirstUrlServlet")
public class FirstUrlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("userName");
        out.print("Welcome "+n+"<br/>");

        out.print("<a href='SecondUrlServlet?uname="+n+"'>visit</a>");

        out.close();
    }
}
