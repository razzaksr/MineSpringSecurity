package auth.spring.MySpringSecurity.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth.spring.MySpringSecurity.model.Data;

@Repository
public interface DataRepo extends JpaRepository<Data, Integer>
{
	
}
