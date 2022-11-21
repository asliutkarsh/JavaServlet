package com.example.javaservlet.ques6.Chat;

import dto.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "DeleteRoomServlet", value = "/DeleteRoomServlet")
public class DeleteRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if (session!=null){
            Users users = (Users) session.getAttribute("user");
            if (deleteRoom(users.getRoom_no())){
                session.invalidate();
            }
            response.sendRedirect("login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean deleteRoom(String room_no){
        boolean status = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123456");
            PreparedStatement ps = connection.prepareStatement("DELETE FROM chatdata WHERE room_no = ?");
            ps.setString(1,room_no);
            if (ps.execute()){
                status = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}
