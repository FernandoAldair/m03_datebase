package com.example.m03_datebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserController {
    UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<UserDto> readAll(){
        List<UserDto> users = userDAO.findAll().stream().map(UserDto::new).collect(Collectors.toList());
        return users;
    }

    public UserDto getUserById(Integer id){
        Optional<User> user = userDAO.findById(id);
        if (user.isPresent()) return new UserDto(user.get());
        else return null;
    }

    public UserDto addUser(UserDto userDto){
        User user = new User(userDto);
        userDAO.save(user);
        return userDto;
    }

    public void removeUser(Integer id){
        userDAO.deleteById(id);
    }

    public UserDto updateUser(UserDto userDto,Integer id){
        User user = new User(userDto);
        return userDAO.findById(id).map(u ->{
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            u.setFull_name(user.getFull_name());
            userDAO.save(u);
            return new UserDto(u);
        }).orElseGet(() ->{
            UserDto userDto1 = new UserDto(userDAO.save(user));
            return userDto1;
        });
    }


}
