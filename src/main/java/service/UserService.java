package service;

import product.Shoe;
import user.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void add(User user);
    User findById(int id);
    boolean checkUser(String email,String pass);
    List<Shoe> findAllProduct();
    User searchByEmail(String email);
}
