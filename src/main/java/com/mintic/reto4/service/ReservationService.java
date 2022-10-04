/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.service;

import com.mintic.reto4.model.Reservation;
import com.mintic.reto4.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r) {
        if (r.getIdReservation() == null) {
            return reservationRepository.save(r);
        } else {
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if (e.isPresent()) {
                return r;
            } else {
                return reservationRepository.save(r);
            }
        }
    }

    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> r2 = reservationRepository.getReservation(r.getIdReservation());
            if (r2.isPresent()) {
                if (r.getStartDate() != null) {
                    r2.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate() != null) {
                    r2.get().setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus() != null) {
                    r2.get().setStatus(r.getStatus());
                }
                reservationRepository.save(r2.get());
                return r2.get();
            } else {
                return r;
            }
        } else {
            return r;
        }
    }

    public void delete(int id) { 
        Optional<Reservation> r = reservationRepository.getReservation(id);
        if (r.isPresent()) {
            reservationRepository.delete(r.get()); 
        } 
    }

}
