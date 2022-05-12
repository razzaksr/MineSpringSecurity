package auth.spring.MySpringSecurity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auth.spring.MySpringSecurity.model.Data;
import auth.spring.MySpringSecurity.service.DataService;

@RestController
public class APIController 
{
	@Autowired
	DataService serv;
	
	@GetMapping("/")
	public List<Data> callView()
	{
		return serv.viewAll();
	}
	
	@PostMapping("/")
	public Data callCreate(@RequestBody Data data)
	{
		return serv.create(data);
	}
	
	@GetMapping("/{id}")
	public Optional<Data> callOne(@PathVariable("id") int id)
	{
		return serv.viewOne(id);
	}
}
