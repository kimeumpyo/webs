package exam04.config;

import exam04.member.MemberDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.FilterType;

@Configuration
//@ComponentScan(value={"exam05.member"})
//@ComponentScan("exam04.member") // 1개일 경우 생략이 가능하다

/*@ComponentScan(basePackages = "exam04.member",
excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = {ManualBean.class}))*/ // ManualBean.class 제외!

/*@ComponentScan(basePackages = "exam04.member",
    excludeFilters = @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class))*/ // ManualBean.class 제외!

@ComponentScan(basePackages = "exam04.member",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,
    pattern = "exam04.member.*Dao"))
public class AppCtx {
   /*
    @Bean
    public MemberDao memberDao(){
        System.out.println("수동 등록 빈!");
        return new MemberDao();
    }
    */
}
