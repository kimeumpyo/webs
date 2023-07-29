package jdbcex;

import java.sql.*;

public class Ex04 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/madang";
        String user = "root", password = "aA!123456";

        String key = "축구";
        String sql = "SELECT * FROM book WHERE bookname LIKE ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + key + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int bookid = rs.getInt("bookid");
                String bookname = rs.getString("bookname");
                String publisher = rs.getString("publisher");
                int price = rs.getInt("price");

                System.out.printf("bookid=%d, bookname=%s, publisher=%s, price=%d%n", bookid, bookname, publisher, price);
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
