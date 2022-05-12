package auth.spring.MySpringSecurity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import auth.spring.MySpringSecurity.model.Data;
import auth.spring.MySpringSecurity.model.User;
import auth.spring.MySpringSecurity.service.DataService;
import auth.spring.MySpringSecurity.service.UserService;

@SpringBootApplication
public class MySpringSecurityApplication {
	
	@Autowired
	DataService serv;
	
	@Autowired
	UserService userv;
	
	@Autowired
	PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(MySpringSecurityApplication.class, args);
	}
	
	
	@PostConstruct
	public void init()
	{
		// for initial data entries
		/*Data d1=new Data("Razak Mohamed S", new String[] {"java","react"}, 987656789L);
		Data d2=new Data("Sabarinathan S", new String[] {"react","webex"}, 987663663L);
		Data d3=new Data("Rasheedha R", new String[] {"javascript","react"}, 987352723L);
		
		serv.create(d1);serv.create(d2);serv.create(d3);*/
		
		// for db user initialization
		/*User user1=new User("zealousrazzak",encoder.encode("zealous") , "Razak Mohamed Shahul hameed");
		User user2=new User("zealousrasheedha", encoder.encode("zealous"), "Rasheedha Razak Mohamed");
		User user3=new User("zealousrajiya", encoder.encode("zealous"), "Rajiya Razak Mohamed");
		
		userv.createUser(user3);userv.createUser(user1);userv.createUser(user2);*/
	}

}
