package com.example.hotel.controllers;

import com.example.hotel.models.ReservaModel;
import com.example.hotel.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ArrayList<ReservaModel>> getReservas()  {
        return new ResponseEntity<>(reservaService.getReservas(), HttpStatus.OK)  ;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ReservaModel>> getReservaById (@PathVariable("id") long id){
        return new ResponseEntity<>(reservaService.getReservabyId(id),HttpStatus.OK) ;
    }

    @PostMapping()
    public ResponseEntity<Object> createReserva (@RequestBody ReservaModel reserva) throws ParseException {
        boolean flag = reservaService.verifyReserva(reserva);

        if (flag){
            return new ResponseEntity<>(reservaService.createReserva(reserva),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Invalid Date",HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteReserva(@PathVariable("id") long id){
        boolean ok = reservaService.deleteReserva(id);

        if (ok) {
            return new ResponseEntity<>("Reservation Deleted",HttpStatus.OK) ;
        }else{
            return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
        }
    }
}
