package com.record.srcode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.record.srcode.config
 * @ClassName SecurityConfiguration
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/21
 */
@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/").permitAll().
                antMatchers("/emission/**").hasRole("emission");

        httpSecurity.formLogin();


        httpSecurity.logout();

        return httpSecurity.build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        
        UserDetailsService userDetailsService = (u) -> {
            if (!u.equals("ryan")) {
                throw new UsernameNotFoundException("user not found");
            }
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("emission");
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(simpleGrantedAuthority);
            UserDetails userDetails = new User(u, "123456", authorities);
            return userDetails;
        };

        userDetailsService.loadUserByUsername("ryan");
        return userDetailsService;
    }
}
