package com.codefunde.usermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    private List<User> users;

    public UserService(List<User> users) {
        this.users = new ArrayList<>();
        users.add(new User(1, "arvind","Arvind@gmail.com"));
    }

    public List<User> getUsers() {
        logger.info("total users - " + users.size());
        return users;
    }

    public String adduser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return " User added successfully";
    }
    public String updateUser(User user) {
        User toDelete = users.stream().filter(user1 -> user1.getId() == user.getId()).findFirst().get();
        users.remove(toDelete);
        users.add(user);
        return " User added successfully";
    }
    public Optional<User> findById(long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public void delete(User user) {
        users.remove(user);
    }
}
