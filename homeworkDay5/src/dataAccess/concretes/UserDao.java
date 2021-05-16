package dataAccess.concretes;

import dataAccess.abstracts.UserDaoService;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements UserDaoService {

    List<User> users = new ArrayList<>();


    @Override
    public void add(User user) {
        users.add(user);
        System.out.println(user.getFirstName().toUpperCase() + " " + user.getLastName().toUpperCase() + "Eklendi.");
    }

    @Override
    public boolean checkEmail(User user) {
        for (User user1 : users) {

            if (user1.getEmail() == user.getEmail()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean loginCheck(String email, String password) {
        for (User user2 : users) {

            if (user2.getEmail() == email && user2.getPassword() == password) {
                return true;
            }
        }
        return false;
    }
}