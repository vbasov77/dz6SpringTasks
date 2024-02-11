package com.example.dz6Tasks.services;

import com.example.dz6Tasks.models.Performer;
import com.example.dz6Tasks.repositories.PerformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformerService {

    @Autowired
    private PerformerRepository performerRepository;

    public List<Performer> findAll() {
        return performerRepository.findAll();
    }
}
