package com.example.javaservlet.ques6.Chat;

import dto.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RoomServlet", value = "/RoomServlet")
public class RoomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if (session!=null){
            Users users = (Users) session.getAttribute("user");
            users.setRoom_no(request.getParameter("room_no"));
            session.setAttribute("user", users);
            response.sendRedirect("chat.jsp");
        }
    }
}
