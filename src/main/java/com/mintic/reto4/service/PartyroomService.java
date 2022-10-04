/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.service;

import com.mintic.reto4.model.Partyroom;
import com.mintic.reto4.repository.PartyroomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class PartyroomService {

    @Autowired
    private PartyroomRepository partyroomRepository;

    public List<Partyroom> getAll() {
        return partyroomRepository.getAll();
    }

    public Optional<Partyroom> getPartyroom(int id) {
        return partyroomRepository.getPartyroom(id);
    }

    public Partyroom save(Partyroom p) {
        if (p.getId() == null) {
            return partyroomRepository.save(p);
        } else {
            Optional<Partyroom> e = partyroomRepository.getPartyroom(p.getId());
            if (e.isPresent()) {
                return p;
            } else {
                return partyroomRepository.save(p);
            } 
        }
    }

       public Partyroom update(Partyroom p) {
        if (p.getId() != null) {
            Optional<Partyroom> p2 = partyroomRepository.getPartyroom(p.getId());
            if (p2.isPresent()) {
                if (p.getName() != null) {
                    p2.get().setName(p.getName());
                }
                if (p.getOwner() != null) {
                    p2.get().setOwner(p.getOwner());
                }
                if (p.getCapacity() != null) {
                    p2.get().setCapacity(p.getCapacity());
                }
                if (p.getDescription() != null) {
                    p2.get().setDescription(p.getDescription());
                }
                partyroomRepository.save(p2.get());
                return p2.get();
            } else {
                return p;
            }
        } else {
            return p;
        }
    }
    
    public void delete(int id){ 
        Optional<Partyroom> p = partyroomRepository.getPartyroom(id);
            if(p.isPresent()){
                partyroomRepository.delete(p.get()); 
            } 
    }
    
}
