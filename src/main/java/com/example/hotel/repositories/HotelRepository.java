package com.example.hotel.repositories;

import com.example.hotel.models.HotelModel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<HotelModel, Long> {
}
