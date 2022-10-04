/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.service;

import com.mintic.reto4.model.Score;
import com.mintic.reto4.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score s) {
        if (s.getIdScore() == null) {
            return scoreRepository.save(s);
        } else {
            Optional<Score> e = scoreRepository.getScore(s.getIdScore());
            if (e.isPresent()) {
                return s;
            } else {
                return scoreRepository.save(s);
            }
        }
    }
    
    public Score update(Score s) {
        if (s.getIdScore() != null) {
            Optional<Score> s2 = scoreRepository.getScore(s.getIdScore());
            if (s2.isPresent()) {
                if (s.getScore() != null) {
                    s2.get().setScore(s.getScore());
                } 
                scoreRepository.save(s2.get());
                return s2.get();
            } else {
                return s;
            }
        } else {
            return s;
        }
    }
    
    public void delete(int id){ 
        Optional<Score> s = scoreRepository.getScore(id);
            if(s.isPresent()){
                scoreRepository.delete(s.get()); 
            } 
    }

    
}
