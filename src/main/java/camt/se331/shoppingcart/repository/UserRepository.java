package camt.se331.shoppingcart.repository;

import org.hsqldb.rights.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Arthur on 2016/4/19.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findByEmailAndPassword(String email,String password);
}
