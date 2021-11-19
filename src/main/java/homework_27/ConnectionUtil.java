package homework_27;

import java.sql.*;

public class ConnectionUtil {

    private static final String url = "jdbc:mysql://localhost:3306/university";
    private static final String user = "root";
    private static final String password = "secret123";

    public static Connection getCon() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.err.println("Подключение успешно");
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться");
        }
        return conn;
    }
}

