package com.wsservice.repositories.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.wsservice.users.Status;
import com.wsservice.users.Users;

@Component
public class UsersRepositoryTeste {

	private static final List<Users> users = new ArrayList<Users>();

	@PostConstruct
	public void initData() {
		Users user = new Users();
		user.setId(1);
		user.setName("bob");
		user.setEmail("bob@gmail.com");
		user.setPhone("99999");

		Users user2 = new Users();
		user2.setId(2);
		user2.setName("meg");
		user2.setEmail("meg@gmail.com");
		user2.setPhone("66666");

		Users user3 = new Users();
		user3.setId(3);
		user3.setName("carla");
		user3.setEmail("carla@gmail.com");
		user3.setPhone("24566666");

		Users user4 = new Users();
		user4.setId(4);
		user4.setName("Rivaldo");
		user4.setEmail("rivaldo@gmail.com");
		user4.setPhone("566677777");

		users.add(user);
		users.add(user2);
		users.add(user3);
		users.add(user4);

	}
	

	public Users findById(int id) {

		Optional<Users> user = users.stream().filter(use -> use.getId() == id).findAny();

		if (user.isPresent()) {
			return user.get();
		}

		return null;

	}
	

	public List<Users> findAll() {

		return users;
	}
	

	public Status deleteById(int id) {

		Optional<Users> user = users.stream().filter(use -> use.getId() == id).findAny();

		if (user.isPresent()) {

			users.remove(user.get());

			return Status.SUCESSO;
		}

		return Status.ERRO;

	}

}
