package models.member;

import controllers.member.JoinForm;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public boolean register(JoinForm joinForm) {
        String sql = "INSERT INTO member(userId, userPw, userNm, mobile)" +
                "VALUES(?, ?, ?, ?)";
        // 유동성
        String userPw = BCrypt.hashpw(joinForm.getUserPw(), BCrypt.gensalt(12));

        int affectedRows = jdbcTemplate.update(sql, joinForm.getUserId(),
                userPw, joinForm.getUserNm(), joinForm.getMobile());

        return affectedRows > 0;
    }

    public Users get(String userId) {
        try {
            String sql = "SELECT * FROM member WHERE userId = ?";
            // 람다식!
            Users user = jdbcTemplate.queryForObject(sql, (rs, i) -> {

                return Users.builder()
                        .userNo(rs.getLong("userNo"))
                        .userId(rs.getString("userId"))
                        .userPw(rs.getString("userPw"))
                        .userNm(rs.getString("userNm"))
                        .mobile(rs.getString("mobile"))
                        .build();
            }, userId);
            return user;

        } catch (Exception e) {
            return null;
        }
    }

    public boolean exists(String userId) {
        long cnt = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM member WHERE userId = ?",
                long.class, userId);

        return cnt > 0;
    }
}
