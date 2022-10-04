/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mintic.reto4.service;

import com.mintic.reto4.model.Message;
import com.mintic.reto4.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message m) {
        if (m.getIdMessage() == null) {
            return messageRepository.save(m);
        } else {
            Optional<Message> e = messageRepository.getMessage(m.getIdMessage());
            if (e.isPresent()) {
                return m;
            } else {
                return messageRepository.save(m);
            }
        }
    }
    
    public Message update(Message m) {
        if (m.getIdMessage() != null) {
            Optional<Message> m2 = messageRepository.getMessage(m.getIdMessage());
            if (m2.isPresent()) {
                if (m.getMessageText() != null) {
                    m2.get().setMessageText(m.getMessageText());
                } 
                messageRepository.save(m2.get());
                return m2.get();
            } else {
                return m;
            }
        } else {
            return m;
        }
    }
    
    public void delete(int id){ 
        Optional<Message> m = messageRepository.getMessage(id);
            if(m.isPresent()){
                messageRepository.delete(m.get()); 
            } 
    }
    
}
