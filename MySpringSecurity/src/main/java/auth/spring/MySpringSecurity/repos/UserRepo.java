package auth.spring.MySpringSecurity.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth.spring.MySpringSecurity.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
	public User findByUsername(String user);
}
