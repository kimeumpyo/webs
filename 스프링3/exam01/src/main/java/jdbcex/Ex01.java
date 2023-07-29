package jdbcex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/madang?user=root&password=aA!123456";

        try (Connection conn = DriverManager.getConnection(url); // 알아서 close 가 실행된다!
             Statement stmt = conn.createStatement()) {

            String sql = "INSERT INTO book2 VALUES(4, '책', '출판사4', 10000)";
            int affectedRows = stmt.executeUpdate(sql);
            System.out.println(affectedRows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
