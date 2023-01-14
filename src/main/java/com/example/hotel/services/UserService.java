package com.example.hotel.services;

import com.example.hotel.models.UserModel;
import com.example.hotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserbyId (long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> getByTelefono (long telefono){
        return userRepository.findByTelefono(telefono);
    }

    public boolean deleteUser(long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
