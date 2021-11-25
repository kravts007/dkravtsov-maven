package homework_27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String PASSWORD = "secret123";
    private static final Connection CONNECTION = buildConn();

    private static Connection buildConn() {
        Connection localConn = null;
        try {
            localConn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.err.println("Подключение успешно");
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться");
        }
        return localConn;
    }

    public static Connection getConn() {
        return CONNECTION;
    }

    public static void shutdown() {
        try {
            CONNECTION.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

