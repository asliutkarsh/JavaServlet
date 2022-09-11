package com.example.javaservlet.ques4.hidden;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstHiddenServlet", value = "/FirstHiddenServlet")
public class FirstHiddenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name=request.getParameter("userName");
        out.print("Welcome "+name);
        //String address = request.getParameter("address");
        out.print("<form action='SecondHiddenServlet'>");
        out.print("<input type='hidden' name='uname' value='"+name+"'>");
        //out.print("<input type='hidden' name='uaddress' value='"+address+"'>");
        out.print("<input type='submit' value='go'>");
        out.print("</form>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
