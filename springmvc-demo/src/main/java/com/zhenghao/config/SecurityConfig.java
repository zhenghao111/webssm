package com.zhenghao.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity//包含@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

//        http.csrf().disable()
//            .formLogin()
//            .and()
//            .authorizeRequests()
//                .antMatchers("/spitters/me").authenticated()
//                .antMatchers(HttpMethod.POST, "/spitter/register").authenticated()
//                .anyRequest().permitAll()
//            .and()
//            .requiresChannel()
//                .antMatchers("/").requiresInsecure()
//                .antMatchers("/spitter/register").requiresSecure()
//            .and()
//            .httpBasic().realmName("spitter");
        http.authorizeRequests()
                .anyRequest().permitAll()
        .and()
        .csrf().disable();


    }
}
