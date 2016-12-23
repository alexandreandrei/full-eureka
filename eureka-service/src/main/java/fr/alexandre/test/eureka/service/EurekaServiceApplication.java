package fr.alexandre.test.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }

}

@RestController
class TasksController {

    private static List<TaskDto> allTasks = new ArrayList<TaskDto>();

    static {
        TaskDto task1 = new TaskDto.Builder()
                .withTitle("Faire les valises")
                .withDescription("Penser à la crème solaire")
                .build();
        allTasks.add(task1);
    }

    @RequestMapping("/tasks")
    public List<TaskDto> getAllTasks() {
        return allTasks;
    }

}