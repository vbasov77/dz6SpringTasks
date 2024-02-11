package com.example.dz6Tasks.repositories;

import com.example.dz6Tasks.models.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformerRepository extends JpaRepository<Performer, Long> {

    List<Performer> findAllBy();
}
