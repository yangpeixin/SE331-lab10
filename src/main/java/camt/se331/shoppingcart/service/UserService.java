package camt.se331.shoppingcart.service;


import java.util.List;

/**
 * Created by Arthur on 2016/4/19.
 */
public interface UserService {
    public List<org.hsqldb.rights.User> findAll();
    public org.hsqldb.rights.User findByUserName(String username);
}

