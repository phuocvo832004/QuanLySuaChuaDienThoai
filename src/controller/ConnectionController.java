package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionController {
    
    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suachuadienthoai", "phuoc", "123456");

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy driver MySQL JDBC.");
            e.printStackTrace();
        } catch (SQLException ex) {
            System.err.println("Không thể kết nối tới cơ sở dữ liệu.");
            ex.printStackTrace();
        }
        return conn;
    }
}
