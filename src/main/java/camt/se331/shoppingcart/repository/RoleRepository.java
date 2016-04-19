package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Arthur on 2016/4/19.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
}
