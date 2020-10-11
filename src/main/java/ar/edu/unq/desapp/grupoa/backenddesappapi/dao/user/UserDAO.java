package ar.edu.unq.desapp.grupoa.backenddesappapi.dao.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {
}
