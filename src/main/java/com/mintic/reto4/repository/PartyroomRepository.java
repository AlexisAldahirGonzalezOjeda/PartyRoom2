/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.repository;

import com.mintic.reto4.model.Partyroom;
import com.mintic.reto4.repository.crudRepository.PartyroomCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public class PartyroomRepository {

    @Autowired
    private PartyroomCrudRepository partyroomCrudRepository;

    public List<Partyroom> getAll() {
        return (List<Partyroom>) partyroomCrudRepository.findAll();
    }

    public Optional<Partyroom> getPartyroom(int id) {
        return partyroomCrudRepository.findById(id);
    }

    public Partyroom save(Partyroom c) {
        return partyroomCrudRepository.save(c);
    }

    public void delete(Partyroom c) {
        partyroomCrudRepository.delete(c);
    }

}