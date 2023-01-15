package com.example.hotel.controllers;

import com.example.hotel.models.HotelModel;
import com.example.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController()
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping()
    public ArrayList<HotelModel> getHotels(){
        return hotelService.getHotels();
    }

    @GetMapping(path = "/{id]")
    public Optional<HotelModel> getHotelbyId(@PathVariable("id") long id){
        return hotelService.getHotelbyId(id);
    }

    @PostMapping()
    public HotelModel saveHotel(@RequestBody HotelModel hotel){
        return hotelService.saveHotel(hotel);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteHotel(@PathVariable("id") long id){
        boolean ok = hotelService.deleteHotel(id);
        if (ok) {
            return "Hotel "+ id+ " deleted";
        }else{
            return "Couldn´t delete hoteld "+id;
        }
    }
}
