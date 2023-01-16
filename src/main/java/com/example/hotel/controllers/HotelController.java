package com.example.hotel.controllers;

import com.example.hotel.models.HotelModel;
import com.example.hotel.services.HotelService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController()
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping()
    public ResponseEntity<ArrayList<HotelModel>> getHotels(){
        return new ResponseEntity<>(hotelService.getHotels(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<HotelModel>> getHotelbyId(@PathVariable("id") long id){
        return new ResponseEntity<>(hotelService.getHotelbyId(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<HotelModel> saveHotel(@RequestBody HotelModel hotel){
        return new ResponseEntity<>(hotelService.saveHotel(hotel),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") long id){
        boolean ok = hotelService.deleteHotel(id);
        if (ok) {
            return new ResponseEntity<>("Hotel "+ id+ " deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Couldn´t delete hotel "+ id,HttpStatus.NOT_FOUND);
        }
    }
}
