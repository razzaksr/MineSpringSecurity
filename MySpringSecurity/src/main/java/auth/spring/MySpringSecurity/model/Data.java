package auth.spring.MySpringSecurity.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Data 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String[] skills;
	private long contact;
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Data(int id, String name, String[] skills, long contact) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
		this.contact = contact;
	}
	public Data(String name, String[] skills, long contact) {
		super();
		this.name = name;
		this.skills = skills;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", skills=" + Arrays.toString(skills) + ", contact=" + contact
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
}
