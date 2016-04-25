package camt.se331.shoppingcart.service;


import camt.se331.shoppingcart.entity.User;

import java.util.List;

/**
 * Created by Arthur on 2016/4/19.
 */
public interface UserService {
    public List<User> findAll();
    public User findByUserName(String username);
}

