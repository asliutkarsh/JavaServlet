package com.example.javaservlet.ques5;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("ques5.html").include(request, response);

        String name=request.getParameter("name");
        String password=request.getParameter("password");



        if(password.equals("123456")){
            out.print("You are successfully logged in!");
            out.print("<br>Welcome, "+name);
            String cname = name.split(" ")[0];
            Cookie ck=new Cookie("name",cname);
            response.addCookie(ck);
        }else{
            out.print("sorry, username or password error!");
            request.getRequestDispatcher("cookieslogin.html").include(request, response);
        }

        out.close();
    }
}
