package org.dodolook.security.demo.pojo;

import com.fasterxml.jackson.annotation.JsonView;

public class User {

	public interface UserSimpleView{};
	
	public interface UserDetilView extends UserSimpleView{};
	
	@JsonView(UserSimpleView.class)
	private String name;
	@JsonView(UserSimpleView.class)
	private String age;
	@JsonView(UserSimpleView.class)
	private String password;
	
	public User() {}
	
	
	public User(String name, String age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", password=" + password + "]";
	}
	
	
}
