package com.security.authenticationInMemory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/

    //Most Restrictive to Least Restrictive
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/specialOffer/**").hasAnyRole("admin","privilege")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .defaultSuccessUrl("/home", true)
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("CommonUser")
                    .password(bCryptPasswordEncoder().encode("password1"))
                    .roles("user")
                .and()
                .withUser("privilegedUser")
                    .password(bCryptPasswordEncoder().encode("password2"))
                    .roles("privilege")
                .and()
                .withUser("Admin")
                    .password(bCryptPasswordEncoder().encode("admin123"))
                    .roles("admin");
    }


}
