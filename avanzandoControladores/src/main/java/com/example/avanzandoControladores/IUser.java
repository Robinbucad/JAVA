package com.example.avanzandoControladores;

import java.util.List;

public interface IUser {

    void addUser(User user);

    List<User> getUserList();

    User getUserById(String id);

}
