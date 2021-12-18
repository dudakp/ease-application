package sk.fei.tp.ease.spring.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests -> authorizeRequests
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/v3/**", "/api-docs/**", "/swagger/**").permitAll()
                .anyRequest().authenticated()
        )
                .oauth2ResourceServer().jwt();
    }
}
