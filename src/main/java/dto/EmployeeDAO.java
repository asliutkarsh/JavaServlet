package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    public int registerEmployee(Employee employee) throws SQLException {
        int result =0;
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123456")) {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO employee(first_name, last_name, username, password, address, contact) VALUES (?,?,?,?,?,?)");
            ps.setString(1,employee.getFirstName());
            ps.setString(2,employee.getLastName());
            ps.setString(3,employee.getUsername());
            ps.setString(4,employee.getPassword());
            ps.setString(5,employee.getAddress());
            ps.setString(6,employee.getContact());

            result = ps.executeUpdate();
        }
        return result;
    }
}
