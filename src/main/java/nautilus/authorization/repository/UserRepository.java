package nautilus.authorization.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nautilus.authorization.model.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>{

	User findByPhone(String phone);
	
}
