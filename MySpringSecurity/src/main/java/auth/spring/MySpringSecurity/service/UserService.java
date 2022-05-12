package auth.spring.MySpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import auth.spring.MySpringSecurity.model.User;
import auth.spring.MySpringSecurity.repos.UserRepo;

@Service
public class UserService implements UserDetailsService 
{
	@Autowired
	UserRepo repo;
	
	public User createUser(User user)
	{
		return repo.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=repo.findByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException(username);
		}
		return user;
	}
}
