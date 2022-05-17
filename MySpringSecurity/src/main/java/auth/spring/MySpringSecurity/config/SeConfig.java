package auth.spring.MySpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import auth.spring.MySpringSecurity.service.UserService;

@Configuration
@EnableWebSecurity
public class SeConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	UserService serv;
	
	// jwt failed
	@Autowired
	JWTTokenHelper helper;
	
	@Autowired
	APIAuthenticationEntryPoint api;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		// inmemory
		auth.inMemoryAuthentication().withUser("zealous").password(passwordEncoder().encode("zealous")).authorities("ADMIN");
		
		//db authentication
		auth.userDetailsService(serv).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	//jwt failed
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// without security even default "user" and generated password
		//http.authorizeRequests().anyRequest().permitAll();
		//http.csrf().disable();// for post request 
		
		
		// with login form basic and inmemory authentication
		
//		http.authorizeRequests().anyRequest().authenticated();
//		http.csrf().disable();// for post request 
//		http.httpBasic();
//		http.formLogin();
		
		
		
		// db login
//		http.authorizeRequests().anyRequest().authenticated();
//		http.csrf().disable();// for post request 
//		http.httpBasic();
//		http.formLogin();
		
		// jwt for react
		// but its failed to implement
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
//		and().exceptionHandling()
//		.authenticationEntryPoint(api).and()
//		.authorizeRequests()
//		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest().authenticated();
//		http.addFilterBefore(new JWTAuthenticationFilter(serv, helper),
//				UsernamePasswordAuthenticationFilter.class);
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
		.authenticationEntryPoint(api).and()
		.authorizeRequests((request) -> request.antMatchers("/auth/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated())
		.addFilterBefore(new JWTAuthenticationFilter(serv, helper),
				UsernamePasswordAuthenticationFilter.class);

		http.csrf().disable().cors().and().headers().frameOptions().disable();
	}

	
	// jwt failed
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		// TODO Auto-generated method stub
//		//web.ignoring().antMatchers("/");
//	    web.ignoring().antMatchers("/auth/**");
//	}
	
}
