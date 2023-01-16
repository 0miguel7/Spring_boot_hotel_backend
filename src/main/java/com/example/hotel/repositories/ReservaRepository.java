package com.example.hotel.repositories;

import com.example.hotel.models.ReservaModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ReservaRepository extends CrudRepository<ReservaModel,Long> {
    public abstract ArrayList<ReservaModel> findReservaModelByHabitacionid(long id);
}
