package com.example.hotel.controllers;

import com.example.hotel.models.RoomModel;
import com.example.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController()
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping()
    public ResponseEntity<ArrayList<RoomModel>> getRooms(){
        return new ResponseEntity<>(roomService.getRooms(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<RoomModel>> getRoombyId(@PathVariable("id") long id){
        return  new ResponseEntity<>(roomService.getRoombyId(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<RoomModel> saveRoom(@RequestBody RoomModel room){
        return new ResponseEntity<>(roomService.saveRoom(room),HttpStatus.CREATED );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoom(@PathVariable("id") long id){
        boolean ok = roomService.deleteRoom(id);
        if (ok) {
            return  new ResponseEntity<>("Room"+ id + " deleted",HttpStatus.OK) ;
        }else{
            return new ResponseEntity<>("Room"+ id + " was not found",HttpStatus.BAD_REQUEST) ;
        }

    }
}
