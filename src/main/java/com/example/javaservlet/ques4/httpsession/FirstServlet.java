package com.example.javaservlet.ques4.httpsession;

import dto.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    public FirstServlet() {
        super();
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =new User();
        HttpSession session=request.getSession();

        user.setFname(request.getParameter("fname"));
        user.setLname(request.getParameter("lname"));
        session.setAttribute("user",user);
        response.sendRedirect("httptwo.html");
    }
}
