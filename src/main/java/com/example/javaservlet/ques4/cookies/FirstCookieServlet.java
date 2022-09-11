package com.example.javaservlet.ques4.cookies;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstCookieServlet", value = "/FirstCookieServlet")
public class FirstCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("userName");
        out.print("Welcome "+n);

        Cookie ck=new Cookie("uname",n);//creating cookie object
        response.addCookie(ck);//adding cookie in the response

        //creating submit button
        out.print("<form action='SecondCookieServlet ' method='post'>");
        out.print("<input type='submit' value='go'>");
        out.print("</form>");

        out.close();
    }
}
