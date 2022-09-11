package com.example.javaservlet.ques5;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet", value = "/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("ques5.html").include(request, response);
        int countC = 0;
        Cookie ck[]=request.getCookies();
        if(ck!=null){
            for (Cookie c:ck) {
                if (c.getName().equals("name")) {
                    out.print("<b>Welcome to Profile</b>");
                    out.print("<br> Name of Cookies is " +c.getName());
                    out.print("<br> Value of Cookies is, " + c.getValue());
                    countC++;
                }
            }
            if (countC == 0 ){
                out.print("Please login first");
                request.getRequestDispatcher("cookieslogin.html").include(request, response);
            }
        }else{
            out.print("Please login first");
            request.getRequestDispatcher("cookieslogin.html").include(request, response);
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
