package com.example.hotel.controllers;
import com.example.hotel.models.UserModel;
import com.example.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public Map<String, Object> getUsers(){
        Map<String, Object> res = new HashMap<>();
        ArrayList<UserModel> listaUsuarios =  userService.getUsers();
        String mensaje = "Users ";
        res.put("Users",listaUsuarios);
        res.put("Message",mensaje);

        return res;
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserbyId (@PathVariable("id") long id){
        return userService.getUserbyId(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getUserbytelefono (@RequestParam("telefono") long telefono){
        return userService.getByTelefono(telefono);
    }

    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable("id")  long id){
        boolean ok = userService.deleteUser(id);
        if (ok){
            return "Deleted user " + id;
        }else{
            return "Couldn´t find user " + id;
        }
    }

    @PostMapping()
    public Map<String, Object> saveUser(@RequestBody UserModel user){
        Map<String, Object> res = new HashMap<>();
        UserModel elementoagregado = userService.saveUser(user);
        res.put("user",elementoagregado);
        String mensaje = "User Created";
        res.put("Message",mensaje);
        return res;
    }



}
