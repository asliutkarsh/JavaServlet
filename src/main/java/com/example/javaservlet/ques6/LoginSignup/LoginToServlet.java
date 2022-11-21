package com.example.javaservlet.ques6.LoginSignup;

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
import java.sql.ResultSet;

@WebServlet(name = "LoginToServlet", value = "/LoginToServlet")
public class LoginToServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users =new Users();
        HttpSession session=request.getSession();
        users.setUsername(request.getParameter("username"));
        users.setPassword(request.getParameter("password"));
        session.setAttribute("user", users);
        if (auth(users)){
            response.sendRedirect("room.html");
        }else {
            response.sendRedirect("errlogin.jsp");
        }
    }
    private boolean auth(Users users){
        boolean status = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123456");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, users.getUsername());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                if (users.getPassword().equalsIgnoreCase(rs.getString("password"))){
                    status = true;break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return status;
    }


}
