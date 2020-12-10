package com.wxz.personal.myproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //内存方式验证用户名和密码
        //auth.inMemoryAuthentication().withUser("lisi").password("0098").roles("admin");

        //自定义UserDetailsService方式验证用户名和密码
        auth.userDetailsService(myUserDetailsService);
    }

    /**
     * permitAll() 无条件允许访问
     * authenticated() 允许认证的用户进行访问
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user2/login3")
                .defaultSuccessUrl("/index").permitAll()
                .and().authorizeRequests()
                .antMatchers("/test").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
