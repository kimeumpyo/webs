package jdbcex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/madang";
        String user = "root", password = "aA!123456";

        String sql = "INSERT INTO book2 VALUES(?, ?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, 5);
            pstmt.setString(2, "책5");
            pstmt.setString(3, "출판사5");
            pstmt.setInt(4, 10000);

            int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
