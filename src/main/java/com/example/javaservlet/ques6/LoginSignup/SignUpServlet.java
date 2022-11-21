package com.example.javaservlet.ques6.LoginSignup;

import dto.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Users users = new Users(username,password);
        if(add(users)){
            response.sendRedirect("successSignup.jsp");
        }else {
            response.sendRedirect("errorSignUp.jsp");
        }

    }

    private boolean add(Users users){
        boolean status = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123456");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?,?)");
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getPassword());

            if (ps.executeUpdate()>0){
                status = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}
