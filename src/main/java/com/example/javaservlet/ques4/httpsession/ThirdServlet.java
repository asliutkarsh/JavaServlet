package com.example.javaservlet.ques4.httpsession;

import dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ThirdServlet", value = "/ThirdServlet")
public class ThirdServlet extends HttpServlet {
    public ThirdServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);

        if (session!=null){
            User user = (User) session.getAttribute("user");
            user.setContact(Long.parseLong(request.getParameter("contact")));
            user.setCity(request.getParameter("city"));
            session.setAttribute("user",user);

            PrintWriter out = response.getWriter();
            out.println(user);
            out.println(session.getId()+" "+session.getCreationTime());
            session.invalidate();
        }
    }
}
