package com.hej.book.springboot.config.auth;

import com.hej.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
                //h2-console사용을 위한 옵션 disable처리
                .headers().frameOptions().disable()
                .and()
                    //URL별 권한관리를 설정하는 옵션의 시작점 -> antMatchers(이거 쓰려면 선언해야함)
                    .authorizeRequests()
                    //권한 관리대ㅏㅇ을 지정하는 옵션(URL,HTTP 메소드별로 관리 가능)
                    .antMatchers("/","/css/**", "/images/**","/js/***","/h2-console/**").permitAll() // 지정된 URL들에 전체 열람권한 부여
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // POST메소드면서 해당 API를 가진 USER권한만 가능하도록 적용
                    .anyRequest().authenticated() // 설정된값들 이외 나머지 URL들에 인증된 사용자만 사용될 수 있도록 설정
                .and()
                    .logout()
                    .logoutSuccessUrl("/") // 로그아웃 하면 전환될 확면
                .and()
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService); // 로그인 성공 후 후속조치를 진행할 interface등록
    }

}
