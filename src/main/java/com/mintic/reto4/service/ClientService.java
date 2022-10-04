/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.service;

import com.mintic.reto4.model.Client;
import com.mintic.reto4.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client c) {
        if (c.getIdClient() == null) {
            return clientRepository.save(c);
        } else {
            Optional<Client> e = clientRepository.getClient(c.getIdClient());
            if (e.isPresent()) {
                return c;
            } else {
                return clientRepository.save(c);
            }
        }
    }

    public Client update(Client c) {
        if (c.getIdClient() != null) {
            Optional<Client> c2 = clientRepository.getClient(c.getIdClient());
            if (c2.isPresent()) {
                if (c.getName() != null) {
                    c2.get().setName(c.getName());
                }
                if (c.getEmail() != null) {
                    c2.get().setEmail(c.getEmail());
                }
                if (c.getPassword() != null) {
                    c2.get().setPassword(c.getPassword());
                }
                if (c.getAge() != null) {
                    c2.get().setAge(c.getAge());
                }
                clientRepository.save(c2.get());
                return c2.get();
            } else {
                return c;
            }
        } else {
            return c;
        }
    }
    
    public void delete(int id){ 
        Optional<Client> c = clientRepository.getClient(id);
            if(c.isPresent()){
                clientRepository.delete(c.get()); 
            } 
    }

}
