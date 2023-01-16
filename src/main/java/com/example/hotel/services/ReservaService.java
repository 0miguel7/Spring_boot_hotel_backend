package com.example.hotel.services;

import com.example.hotel.models.ReservaModel;
import com.example.hotel.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    ReservaRepository reservaRepository;


    public ArrayList<ReservaModel> getReservas()  {
        return (ArrayList<ReservaModel>) reservaRepository.findAll();
    }

    public Optional<ReservaModel> getReservabyId(long id){
        return reservaRepository.findById(id);
    }

    public ReservaModel createReserva(ReservaModel reserva) {
        return reservaRepository.save(reserva);

    }

    public boolean deleteReserva(long id){
        try {
            reservaRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

    public boolean verifyReserva(ReservaModel newReserva) throws ParseException {
        ArrayList<ReservaModel> reservas = reservaRepository.findReservaModelByHabitacionid(newReserva.getHabitacionId());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date newreservainicio = sd.parse(newReserva.getInicio());
        Date newreservafin = sd.parse(newReserva.getFin());

        Date reservainicio;
        Date reservafin;

        for (ReservaModel reserva : reservas) {

            reservainicio = sd.parse(reserva.getInicio());
            reservafin = sd.parse(reserva.getFin());

            if (newreservainicio.before(reservainicio) && newreservafin.before(reservainicio)) {
                continue;
            }

            if (newreservainicio.after(reservafin) && newreservafin.after(reservafin)){
                continue;
            }

            return false;
        }

        return true;
    }

}
