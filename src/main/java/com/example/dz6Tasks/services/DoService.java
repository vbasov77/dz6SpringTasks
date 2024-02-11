package com.example.dz6Tasks.services;

import com.example.dz6Tasks.models.Performer;
import com.example.dz6Tasks.repositories.DoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoService {

    @Autowired
    private DoRepository doRepository;

    public List<String> findPerformersByDoId(Long id){
        return doRepository.findPerformersByDoId(id);
    }
}
