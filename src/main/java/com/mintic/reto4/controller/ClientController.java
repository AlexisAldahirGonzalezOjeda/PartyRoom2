/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.controller;

import com.mintic.reto4.model.Client;
import com.mintic.reto4.service.ClientService;
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
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client c) {
        return clientService.save(c);
    }

    @GetMapping("/{id}")
    public Optional<Client> obtenerClienteId(@PathVariable("id") Integer identificador) {
        return clientService.getClient(identificador);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client change(@RequestBody Client c) {
        return clientService.update(c);
    }

    @DeleteMapping("/{id}") 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer identificador) {
        clientService.delete(identificador);
    }

}
