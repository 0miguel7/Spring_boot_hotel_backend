package com.example.hotel.services;

import com.example.hotel.models.RoomModel;
import com.example.hotel.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    public ArrayList<RoomModel> getRooms (){
        return (ArrayList<RoomModel>) roomRepository.findAll();
    }

    public Optional<RoomModel> getRoombyId (long id){
        return roomRepository.findById(id);
    }

    public RoomModel saveRoom(RoomModel room){
        return roomRepository.save(room);
    }

    public boolean deleteRoom(long id){
        try{
            roomRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
