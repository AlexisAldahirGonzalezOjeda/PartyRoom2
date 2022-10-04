/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.repository;

import com.mintic.reto4.model.Admin;
import com.mintic.reto4.repository.crudRepository.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc
 */
@Repository
public class AdminRepository { 

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll() {
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminCrudRepository.findById(id);
    }

    public Admin save(Admin a) {
        return adminCrudRepository.save(a);
    }

    public void delete(Admin a) {
        adminCrudRepository.delete(a);
    }
    
}
