package jdbcex;

import java.sql.*;

public class Ex02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/madang?user=root&password=aA!123456";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM book2")) {

            while (rs.next()) {
                int bookid = rs.getInt("bookid");
                String bookname = rs.getString("bookname");
                String publisher = rs.getString("publisher");
                int price = rs.getInt("price");
                System.out.printf("bookid=%d, bookname=%s, publisher=%s, price=%d%n", bookid, bookname, publisher, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
