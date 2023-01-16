package com.example.hotel.controllers;

import com.example.hotel.models.ReservaModel;
import com.example.hotel.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaService reservaService;
    @GetMapping()
    public ArrayList<ReservaModel> getReservas()  {
        return reservaService.getReservas();
    }

    @GetMapping(path = "/{id}")
    public Optional<ReservaModel> getReservaById (@PathVariable("id") long id){
        return reservaService.getReservabyId(id);
    }

    @PostMapping()
    public Object createReserva (@RequestBody ReservaModel reserva) throws ParseException {
        boolean flag = reservaService.verifyReserva(reserva);

        if (flag){
            return reservaService.createReserva(reserva);
        }else{
            return "Cruce de horarios";
        }

    }

    @DeleteMapping(path = "/{id}")
    public String deleteReserva(@PathVariable("id") long id){
        boolean ok = reservaService.deleteReserva(id);

        if (ok) {
            return "Reserva eliminada";
        }else{
            return "Resreva no eliminada";
        }
    }
}
