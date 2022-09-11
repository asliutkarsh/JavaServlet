package com.example.javaservlet.ques5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("ques5.html").include(request, response);

        Cookie l = null;
        Cookie[] ck = request.getCookies();
        if (ck!=null){
            for (Cookie c: ck) {
                if (c.getName().equals("name")) {
                    l = c;
                    break;
                }
            }
        }
        if (l !=null){
            l.setMaxAge(0);
            response.addCookie(l);
        }
        out.print("you are successfully logged out!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
