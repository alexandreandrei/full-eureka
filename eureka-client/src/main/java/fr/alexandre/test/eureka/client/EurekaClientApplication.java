package fr.alexandre.test.eureka.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class EurekaClientApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EurekaClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }


    @FeignClient("tasks-service")
    interface TasksClient {

        @RequestMapping(value = "/tasks", method = RequestMethod.GET)
        String getAllTasks();

    }

    @RestController
    public static class TasksController {

        @Autowired
        private TasksClient tasksClient;

        @GetMapping("/tasks")
        public String getAllTasks() {
            return tasksClient.getAllTasks();
        }

    }

}
