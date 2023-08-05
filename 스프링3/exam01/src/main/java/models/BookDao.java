package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 추가
    public boolean insert(Book book) {
        String sql = "INSERT INTO Book2 (bookname, publisher, price) VALUES(?, ?, ?);";
        int affectedRows = jdbcTemplate.update(sql, book.getBookName(),
                book.getPublisher(), book.getPrice());

        return affectedRows > 0; // 쿼리 성공~!
    }

    // 수정
    public boolean update(Book book) {
        String sql = "UPDATE Book2" +
                "   SET " +
                "       bookname=?," +
                "       publisher=?," +
                "       price=? " +
                " WHERE bookid=?";
        int affectedRows = jdbcTemplate.update(sql,  book.getBookName(),
                book.getPublisher(), book.getPrice(), book.getBookId());

        return affectedRows > 0; // 쿼리 성공~!
    }

    // 삭제
    public boolean delete(int bookId) {
        String sql = "DELETE FROM Book2 WHERE bookid=?";
        int affectedRows = jdbcTemplate.update(sql, bookId);
        return affectedRows > 0; // 쿼리 성공~!
    }

    // 목록 조회
    // 람다식
    /*public List<Book> gets() {
        String sql = "SELECT * FROM Book2";
        List<Book> books = jdbcTemplate.query(sql, (rs, i) -> {
                return Book.builder()
                        .bookId(rs.getInt("bookid"))
                        .bookName(rs.getString("bookname"))
                        .publisher(rs.getString("publisher"))
                        .price(rs.getInt("price"))
                        .build();

        });
        */
    public List<Book> gets() {
        String sql = "SELECT * FROM Book2";
//        List<Book> books = jdbcTemplate.query(sql, (rs, i) -> this.mapper(rs, i)); // 1)을 이용
        List<Book> books = jdbcTemplate.query(sql, this::mapper); // 위와 동일하다
        /*
        public List<Book> gets() {
            String sql = "SELECT * FROM Book2";
            List<Book> books = jdbcTemplate.query(sql, new RowMapper<Book>() {
                @Override
                public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return Book.builder()
                            .bookId(rs.getInt("bookid"))
                            .bookName(rs.getString("bookname"))
                            .publisher(rs.getString("publisher"))
                            .price(rs.getInt("price"))
                            .build();
                }
            });
        */

        return books; // 임시
    }

    // 개별 조회
    public Book get(int bookId) {
        try{
            String sql = "SELECT * FROM Book2 WHERE bookid = ?";
            Book book = jdbcTemplate.queryForObject(sql,this::mapper,bookId);
            return book;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

/*        Book book = jdbcTemplate.queryForObject(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return null;
            }
       }, bookId);
        return null; // 임시
*/

    //책의 갯수
    public long getTotal(){
        String sql = "SELECT COUNT(*) FROM Book2";
                Long total = jdbcTemplate.queryForObject(sql, long.class);
        return total;
    }

    // 1)
    private Book mapper(ResultSet rs, int i ) throws SQLException{
        return Book.builder()
                .bookId(rs.getInt("bookid"))
                .bookName(rs.getString("bookname"))
                .publisher(rs.getString("publisher"))
                .price(rs.getInt("price"))
                .build();
    }
}
