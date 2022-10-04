/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.service;

import com.mintic.reto4.model.Admin;
import com.mintic.reto4.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin a) {
        if (a.getIdAdmin() == null) {
            return adminRepository.save(a);
        } else {
            Optional<Admin> e = adminRepository.getAdmin(a.getIdAdmin());
            if (e.isPresent()) {
                return a;
            } else {
                return adminRepository.save(a);
            }
        }
    }
    
    public Admin update(Admin a) {
        if (a.getIdAdmin() != null) {
            Optional<Admin> a2 = adminRepository.getAdmin(a.getIdAdmin());
            if (a2.isPresent()) {
                if (a.getName() != null) {
                    a2.get().setName(a.getName());
                }
                if (a.getEmail() != null) {
                    a2.get().setEmail(a.getEmail());
                }
                if (a.getPassword() != null) {
                    a2.get().setPassword(a.getPassword());
                }
                if (a.getAge() != null) {
                    a2.get().setAge(a.getAge());
                }
                adminRepository.save(a2.get());
                return a2.get();
            } else {
                return a;
            }
        } else {
            return a;
        }
    }
    
    public void delete(int id){ 
        Optional<Admin> a = adminRepository.getAdmin(id);
            if(a.isPresent()){
                adminRepository.delete(a.get()); 
            } 
    }
    
}
