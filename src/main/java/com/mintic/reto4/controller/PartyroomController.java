/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.controller;

import com.mintic.reto4.model.Partyroom;
import com.mintic.reto4.service.PartyroomService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pc
 */
@RestController
@RequestMapping("/api/Partyroom")
public class PartyroomController {

    @Autowired
    private PartyroomService partyroomService;

    @GetMapping("/all")
    public List<Partyroom> getAll() {
        return partyroomService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom save(@RequestBody Partyroom p) {
        return partyroomService.save(p);
    }

    @GetMapping("/{id}")
    public Optional<Partyroom> obtenerPartyroomId(@PathVariable("id") Integer identificador) {
        return partyroomService.getPartyroom(identificador);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Partyroom change(@RequestBody Partyroom p) {
        return partyroomService.update(p);
    }

    @DeleteMapping("/{id}") 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer identificador) {
        partyroomService.delete(identificador);
    }

}
