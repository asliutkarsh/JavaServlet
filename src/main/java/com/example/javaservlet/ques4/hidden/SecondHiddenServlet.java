package com.example.javaservlet.ques4.hidden;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondHiddenServlet", value = "/SecondHiddenServlet")
public class SecondHiddenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Getting the value from the hidden field
        String name=request.getParameter("uname");
        out.print("Hello "+name);
        out.print("<br/>");

        //String address=request.getParameter("uaddress");
        //out.println("Your Address "+address);

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
