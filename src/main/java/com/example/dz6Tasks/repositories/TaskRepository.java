package com.example.dz6Tasks.repositories;

import com.example.dz6Tasks.annotations.LogNotFound;
import com.example.dz6Tasks.models.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Transactional
    @Query(value = "select * from tasks", nativeQuery = true)
    List<Task> findAll();

    void deleteById(Long id);

    @Transactional
    @Query(value = "select * from tasks where status like :status", nativeQuery = true)
    List<Task> findAllByStatus(String status);

    @Transactional
    @Modifying
    @Query(value = "update tasks set description = :description, status = :status where id = :id", nativeQuery = true)
    void updateTask(String description, String status, Long id);

    @LogNotFound
    Task findTaskById(Long id);

    @Transactional
    @Modifying
    @Query(value = "delete from tasks where id = :id", nativeQuery = true)
    void deleteTaskById(Long id);
}
