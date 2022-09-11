package com.example.javaservlet.ques4.httpsession;

import dto.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

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
