package com.example.dz6Tasks.repositories;

import com.example.dz6Tasks.models.Do;
import com.example.dz6Tasks.models.Performer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoRepository extends JpaRepository<Do, Long> {

    @Transactional
    @Query(value = "select p.name from performers p left join do d on d.performer_id = p.id where d.task_id = :id", nativeQuery = true)
    List<String> findPerformersByDoId(Long id);

}
