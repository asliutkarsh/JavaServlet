package com.example.javaservlet.ques4.urlrewrite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

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
