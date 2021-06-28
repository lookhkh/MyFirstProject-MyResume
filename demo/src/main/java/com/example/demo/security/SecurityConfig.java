package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import com.example.demo.mapper.MemberMapper;


@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	CustomUserDetailService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	http.authorizeRequests().antMatchers("/ref/detail").permitAll().antMatchers("/ref").permitAll()
	.antMatchers("/ref/**").hasAnyRole("MEMBER");
	http.formLogin().successHandler(LoginSuccesHandler());
	http.csrf().disable();
	http.logout().permitAll().invalidateHttpSession(true).clearAuthentication(true).logoutSuccessHandler(LogoutHander()).deleteCookies("JSESSIONID");

	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		   auth.authenticationProvider(authenticationProvider(userService));

	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
	
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider(CustomUserDetailService userService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
	
	@Bean
	public HttpFirewall defaultHttpFirewall() {
	   return new DefaultHttpFirewall();
	}
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 @Bean
	 public AuthenticationSuccessHandler LoginSuccesHandler() {
	     return new LoginSuccesHandler("/");
	 }
	 
	 @Bean
	 public LogoutSuccessHandler LogoutHander() {
		 return new LogoutHandler();
	 }

}
