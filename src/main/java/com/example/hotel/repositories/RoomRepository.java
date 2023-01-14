package com.example.hotel.repositories;

import com.example.hotel.models.RoomModel;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomModel,Long> {

}
