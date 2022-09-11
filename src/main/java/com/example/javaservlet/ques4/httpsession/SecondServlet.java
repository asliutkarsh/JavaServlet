package com.example.javaservlet.ques4.httpsession;

import dto.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "SecondServlet", value = "/SecondServlet")
public class SecondServlet extends HttpServlet {
    public SecondServlet(){
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);

        if (session!=null){
            User user = (User) session.getAttribute("user");
            user.setAge(Integer.parseInt(request.getParameter("age")));
            user.setEmail(request.getParameter("email"));
            session.setAttribute("user",user);
            response.sendRedirect("httpthree.html");
        }

    }
}



