/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.repository.crudRepository;

import com.mintic.reto4.model.Score;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author pc
 */
public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {
    
}
