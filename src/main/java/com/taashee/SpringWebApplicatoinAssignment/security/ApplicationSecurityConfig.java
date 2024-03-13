package com.taashee.SpringWebApplicatoinAssignment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Configuration
@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;
	private final DaoUserDetailsService daoUserDetailsService;
	private final CustomSuccessHandler customSuccessHandler;

	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, DaoUserDetailsService daoUserDetailsService,
			CustomSuccessHandler customSuccessHandler) {
		this.passwordEncoder = passwordEncoder;
		this.daoUserDetailsService = daoUserDetailsService;
		this.customSuccessHandler = customSuccessHandler;
		System.out.println(passwordEncoder.encode("password"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
//			.antMatchers(HttpMethod.GET,"/deleteSong").hasAuthority(UserPermission.WRITE.getPermission())
//				.antMatchers(HttpMethod.GET, "/deleteSong").hasAuthority(UserPermission.READ.getPermission())
//				.antMatchers(HttpMethod.POST).hasAuthority(UserPermission.WRITE.getPermission())
				.antMatchers( "/js/**", "/css/**").permitAll()
				.antMatchers("/addCourse", "/addStudent", "/addInstructor").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/**").hasAuthority(UserPermission.COURSE_READ.getPermission()).anyRequest()
				.authenticated().and().formLogin()
                .loginPage("/login-page.jsp") // Specify custom login page URL
                .permitAll() // Allow access to unauthenticated users
                .successHandler(customSuccessHandler)
//			.usernameParameter("user")
//			.passwordParameter("pwd")
//			.defaultSuccessUrl("/songs",true)
				.successHandler(customSuccessHandler).and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(daoUserDetailsService);
		return provider;
	}

	

}
