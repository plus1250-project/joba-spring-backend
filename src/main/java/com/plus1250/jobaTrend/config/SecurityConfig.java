package com.plus1250.jobaTrend.config;
import com.plus1250.jobaTrend.jwt.JwtAuthenticationFilter;
import com.plus1250.jobaTrend.jwt.JwtTokenProvider;
import com.plus1250.jobaTrend.security.AuthenticationEntryPoint;
import com.plus1250.jobaTrend.security.CustomAuthenticationFilter;
import com.plus1250.jobaTrend.security.handler.AuthenticationFailureHandlerImpl;
import com.plus1250.jobaTrend.security.handler.AuthenticationSuccessHandlerImpl;
import com.plus1250.jobaTrend.security.handler.JwtAccessDeniedHandler;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    // 인증 실패,  인증 헤더 전달 실패
    @Autowired
    private final AuthenticationEntryPoint authenticationEntryPoint;

    // 권한 실패
    @Autowired
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    // 인증 성공 핸들러
    @Autowired
    private final AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;

    // 인증 실패 핸들러
    @Autowired
    private final AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    .cors()
                .and()
                .csrf()
                .disable()
                .formLogin().disable()  // jwt를 사용하므로 생략
                .httpBasic().disable()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 사용하지 않음

                .and().exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint) // 인증 실패
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and().authorizeRequests()
                .antMatchers(HttpMethod.POST).permitAll() // 해당 url 허용
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers("**").hasAnyRole("ROLE_USER") // 권한 적용
                .anyRequest().authenticated() // 나머지 요청에 대해서는 인증을 요구
                .and()
                .formLogin()
                .successHandler(authenticationSuccessHandlerImpl)
                .failureHandler(authenticationFailureHandlerImpl)
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .apply(new JwtSecurityConfig(jwtTokenProvider));

//                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    // 사용자 요청 정보로 UserPasswordAuthenticationToken 발급
    @Bean
    public CustomAuthenticationFilter authenticationFilter() throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager());
        // 필터 URL 설정
        customAuthenticationFilter.setFilterProcessesUrl("/login");

        customAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandlerImpl);
        customAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandlerImpl);
        customAuthenticationFilter.afterPropertiesSet();

        return customAuthenticationFilter;
    }

    // jwt 인증, 발급 확인
    @Bean
    public JwtAuthenticationFilter jwtFilter() {
        return new JwtAuthenticationFilter(jwtTokenProvider);
    }

}