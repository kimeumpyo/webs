package config;

import models.BookDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.xml.crypto.Data;

@Configuration
public class AppCtx {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/madang");
        ds.setUsername("root");
        ds.setPassword("aA!123456");

        // 커넥션 풀 설정
        ds.setInitialSize(2); // 초기화할 때 생성할 초기 커넥션 개수 10
        ds.setMaxActive(10); // 최대 커넥션 개수 기본값은 100
        ds.setTestWhileIdle(true); // 검사할지 여부
        ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // 검사 주기10초(기본 5초)
        ds.setMinEvictableIdleTimeMillis(1000 * 60 * 2); // 기본값은 60000밀리초(60초)이다.

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public BookDao bookDao() {
        return new BookDao();
    }

}



