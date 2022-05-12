package auth.spring.MySpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.spring.MySpringSecurity.model.Data;
import auth.spring.MySpringSecurity.repos.DataRepo;

@Service
public class DataService 
{
	@Autowired
	DataRepo repo;
	
	public Data create(Data data)
	{
		return repo.save(data);
	}
	
	public List<Data> viewAll()
	{
		return repo.findAll();
	}
	
	public Optional<Data> viewOne(int id)
	{
		return repo.findById(id);
	}
	
	public void remove(Data data)
	{
		repo.delete(data);
	}
	
	public String removeOne(int id)
	{
		String y=repo.getById(id).getName()+" has deleted";
		repo.deleteById(id);
		return y;
	}
}
