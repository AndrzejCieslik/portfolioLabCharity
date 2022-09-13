package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

public interface UserService {
    User findByUserName(String username);
    void saveUser(User user);
}
