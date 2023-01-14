package com.example.hotel.controllers;

import com.example.hotel.models.RoomModel;
import com.example.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController()
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping()
    public ArrayList<RoomModel> getRooms(){
        return roomService.getRooms();
    }
    @GetMapping(path = "/{id}")
    public Optional<RoomModel> getRoombyId(@PathVariable("id") long id){
        return roomService.getRoombyId(id);
    }

    @PostMapping()
    public RoomModel saveRoom(@RequestBody RoomModel room){
        return roomService.saveRoom(room);
    }

    @DeleteMapping("/{id}")
    public Object deleteRoom(@PathVariable("id") long id){
        boolean ok = roomService.deleteRoom(id);
        if (ok) {
            return "Room " + id + " deleted";
        }else{
            return "Room "+ id +" was not found";
        }

    }
}
