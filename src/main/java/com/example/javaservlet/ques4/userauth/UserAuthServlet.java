package com.example.javaservlet.ques4.userauth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserAuthServlet", value = "/UserAuthServlet")
public class UserAuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String fname = request.getParameter("fname");
        String pass = request.getParameter("password");
        if (pass.equals("123456")){
            out.println("Login SuccessFull");
            out.println("Welcome "+fname);
        }
        else {
            out.println("Wrong Password");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
