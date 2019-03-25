package snack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import snack.model.snack;

public interface snackrepo extends JpaRepository<snack,Integer> {
	snack findByName(String name);

	boolean exists(int id);
}
