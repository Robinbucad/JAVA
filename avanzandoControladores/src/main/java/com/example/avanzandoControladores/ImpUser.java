package com.example.avanzandoControladores;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ImpUser implements IUser{

    List<User> userList = new ArrayList<>();

    public List<User> getUserList(){
        return userList;
    }

    public User getUserById(String id){
        User user = userList.stream() // Uso de stream para trabajar con el array
                .filter(u -> id.equals(u.getId()))  // filtramos que el parametro ID sea igual que el ID de la lista de usuarios
                .findFirst() // Decimos que encuentre el primero (Gestionar que no se puedan tener 2 id iguales)
                .orElse(null); // Si no encuentra ningun Id devovlerá null
        return user;
    }


    public void addUser(User user){
        userList.add(user);z
    }

}
