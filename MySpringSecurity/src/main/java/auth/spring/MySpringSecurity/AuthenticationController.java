package auth.spring.MySpringSecurity;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.spring.MySpringSecurity.config.JWTTokenHelper;
import auth.spring.MySpringSecurity.model.User;
import auth.spring.MySpringSecurity.reqs.AuthenticateByRequest;
import auth.spring.MySpringSecurity.resps.LoginResponse;
import auth.spring.MySpringSecurity.resps.ResponseUserDetails;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:3000")
public class AuthenticationController {
	
	@PostMapping("/")
	public String readingHeader(@RequestHeader(name = "user") String user,@RequestHeader(name = "pass") String pass)
	{
		System.out.println(user+" "+pass);
		return user+" and "+pass+" received";
	}

//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	JWTTokenHelper jWTTokenHelper;
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@RequestBody AuthenticateByRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {
//
//		final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//				authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		User user=(User)authentication.getPrincipal();
//		String jwtToken=jWTTokenHelper.generateToken(user.getUsername());
//		
//		LoginResponse response=new LoginResponse();
//		response.setToken(jwtToken);
//		
//
//		return ResponseEntity.ok(response);
//	}
//	
//	@GetMapping("/userinfo")
//	public ResponseEntity<?> getUserInfo(Principal user){
//		
//		System.out.println("Auth get mapping called "+user);
//		
//		User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
//		
//		ResponseUserDetails userInfo=new ResponseUserDetails();
//		userInfo.setFullname(userObj.getFullname());
//		userInfo.setUserName(userObj.getUsername());
//		
//		
//		return ResponseEntity.ok(userInfo);
//	}
}
