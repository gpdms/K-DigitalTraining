package com.example.springboot.config;

import jdk.jfr.Enabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

//@Configuration 애노테이션은 스프링 프레임워크에서 사용
// 해당 클래스가 스프링의 구성(Configuration) 클래스임을 나타냄
// 구성 클래스는 하나 이상의 Bean 구성 메서드가 정의되어 있으며,
// 이를 통해 애플리케이션에서 사용되는 Bean을 생성하고 구성할 수 있음
@Configuration
//@EnableWebSecurity 애노테이션을 사용하여 웹 보안을 활성화
// WebSecurityConfigurerAdapter 클래스를 확장하여 configure(HttpSecurity http) 메서드를 오버라이드하여 보안 설정을 지정
// configure(AuthenticationManagerBuilder auth) 메서드를 오버라이드하여 사용자 인증 정보를 설정
// passwordEncoder() 메서드를 이용하여 비밀번호 암호화 설정을 지정
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    //데이터베이스 연결을 설정하고, 연결된 데이터베이스로부터 데이터를 읽고 쓰는 작업을 수행할 수 있음
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/member/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();

        //CSRF(Cross-Site Request Forgery) 공격 방지 기능을 해제하는 코드
        //csrf() 메서드는 CSRF 공격 방지 기능을 구현하는 메서드
        //아래 코드에서는 disable() 메서드를 호출하여 이 기능을 해제하도록 설정
        //CSRF 공격은 웹 애플리케이션에서 매우 흔한 보안 공격 중 하나로, 해커가 인증된 사용자의 권한을 훔쳐서 서버에 피해를 줄 수 있는 공격
        // Spring Security에서는 CSRF 공격 방지 기능을 기본으로 제공하여, 이를 방지할 수 있음
        //하지만, 특정한 경우에는 CSRF 공격 방지 기능을 해제해야 할 필요가 있을 수 있음.
        // 예를 들어, RESTful API를 사용하는 경우에는 CSRF 공격 방지 기능을 해제하는 것이 일반적
        http.csrf().disable();  // 개발시 불편함을 없애기 위해
        http.formLogin()
                .loginPage("/login")
                //defaultSuccessUrl() 메서드는 로그인 성공 후 이동할 페이지를 설정
                // 첫 번째 파라미터는 이동할 페이지의 URL을 나타내고,
                // 두 번째 파라미터는 alwaysUse로, 이 값이 true로 설정되면 로그인 성공 후에도 항상 지정된 URL로 이동
                .defaultSuccessUrl("/loginSuccess", true);

        //exceptionHandling() 메서드는 예외 처리를 설정
        // accessDeniedPage() 메서드는 인가 거부 예외가 발생했을 때 보여줄 페이지를 설정
        //user로 로그인해서 admin 페이지 들어가면 예외처리화면 나옴.
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        //logout() 메서드는 로그아웃 설정
        // invalidateHttpSession() 메서드는 로그아웃 시 세션을 무효화할 지 여부를 설정
        // 이 경우 true로 설정되어 있으므로, 로그아웃 시 세션을 무효화
        http.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
    }

    //얘는 inMemory
//    @Autowired
//        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");

//    }

    //구성 클래스에는 @Bean 애노테이션이 붙은 메서드를 정의하여 Bean을 생성하고 반환할 수 있음
    // @Bean 애노테이션을 사용하면 해당 메서드가 반환하는 객체가 스프링 컨테이너에 등록
    // 다른 Bean에서 주입받아 사용할 수 있음
    @Bean //객체생성
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //@Autowired 어노테이션을 사용하여 AuthenticationManagerBuilder 객체를 주입 //만들어진 빈을 연결해서 씀.
    // AuthenticationManagerBuilder 객체는 Spring Security에서 인증 관련 설정을 구성하는 빌더 클래스
    //authenticate() 메서드는 AuthenticationManagerBuilder 객체를 이용하여 사용자 인증 정보를 설정
    // 사용자 인증 정보를 설정하고, 인증 처리를 위한 필터를 등록
    @Autowired
    public void test(){
        System.out.println("-----------------------------test");
        //무조건 실행함.
    }

    //얘는 jdbc
    @Autowired
    public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
        //HikariDataSource는 HikariCP라는 커넥션 풀 라이브러리를 이용한 데이터 소스(Data Source) 구현체 중 하나
        //데이터 소스는 애플리케이션이 데이터베이스와 연결하고, 데이터베이스로부터 데이터를 가져오는 데 사용되는 객체
        // HikariCP는 다른 커넥션 풀 라이브러리에 비해 높은 성능과 낮은 메모리 사용량을 가지고 있어,
        // 많은 양의 데이터를 처리해야 하는 대규모 애플리케이션에서 사용되는 경우가 많음
        //HikariDataSource는 javax.sql.DataSource 인터페이스를 구현하므로,
        // JDBC API를 사용하여 데이터베이스와 연결할 수 있습니다.
        // 이를 위해 데이터베이스 URL, 사용자 이름, 암호 등의 정보를 설정해야 함
        System.out.println("---------->"+dataSource);

        //JdbcTemplate 클래스는 Spring JDBC의 핵심 클래스
        // JDBC를 사용하여 데이터베이스 작업을 수행하는 데 필요한 메서드를 제공
        // DataSource 객체를 생성자로 받아서 초기화
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM user_list WHERE name = ? or name = ?";
        String username = "user";
        String username2 = "admin";
        //Object[] 타입의 배열 params를 선언
        // 배열의 첫 번째 요소에 username 변수를 할당
        // 이렇게 설정된 파라미터는 SQL 쿼리에서 ?를 사용하여 표기
        Object[] params = new Object[]{username, username2};
        //jdbcTemplate 객체의 queryForList() 메서드를 호출
        // SQL 쿼리를 실행하고 그 결과를 List<Map<String, Object>> 타입으로 반환
        // SQL 쿼리에서 사용되는 파라미터는 params 배열에서 가져옵니다.
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, params);
        System.out.println(result);

        //"123"이라는 문자열을 BCryptPasswordEncoder로 암호화한 결과
        // 이 때, BCryptPasswordEncoder는 암호화할 때마다 랜덤한 값을 생성하여 이를 이용하여 암호화를 수행
        // 같은 문자열을 암호화해도 결과가 매번 달라짐. 따라서, 인증 과정에서는 입력받은 비밀번호를
        // 이와 같은 방식으로 암호화하여 저장된 비밀번호와 비교하는 것이 보안상 안전함
        System.out.println(passwordEncoder().encode("123"));

        //Spring Security에서 JDBC를 이용한 인증 설정을 지정
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                //사용자 정보를 조회하는 SQL 쿼리를 지정
                .usersByUsernameQuery(
                        "select name as username, password, enabled from user_list " +
                                "where name = ?")
                //사용자 권한 정보를 조회하는 SQL 쿼리를 지정
                .authoritiesByUsernameQuery(
                        "select name as username, authority from user_list " +
                                "where name = ?")
                //BCryptPasswordEncoder를 이용하여 비밀번호를 암호화하는 설정을 지정
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
