package com.example.javaservlet.ques5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "DummyServlet", value = "/DummyServlet")
public class DummyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie c[] =  request.getCookies();
        int count =0;
        if (c!= null){
            for (Cookie cookie:c) {
                if (cookie.getName().equals("name")){
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProfileServlet");
                    requestDispatcher.forward(request,response);
                    count++;
                }
            }
            if (count == 0){
                response.sendRedirect("cookieslogin.html");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
