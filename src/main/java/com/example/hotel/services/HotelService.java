package com.example.hotel.services;

import com.example.hotel.models.HotelModel;
import com.example.hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public ArrayList<HotelModel> getHotels(){
        return (ArrayList<HotelModel>) hotelRepository.findAll();
    }

    public Optional<HotelModel> getHotelbyId(long id){
        return hotelRepository.findById(id);
    }

    public HotelModel saveHotel(HotelModel hotel){
        return hotelRepository.save(hotel);
    }

    public boolean deleteHotel(long id){
        try {
            hotelRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
