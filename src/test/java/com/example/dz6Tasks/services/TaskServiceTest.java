//package com.example.dz6Tasks.services;
//
//import com.example.dz6Tasks.repositories.TaskRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//public class TaskServiceTest {
//    @InjectMocks
//    private TaskService taskService;
//
//    @Mock
//    private TaskRepository taskRepository;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testDeleteTask() {
//        Long id = 3L;
//        taskService.delete(id);
//
//        Mockito.verify(taskRepository, Mockito.times(1)).deleteById(id);
//    }
//}
