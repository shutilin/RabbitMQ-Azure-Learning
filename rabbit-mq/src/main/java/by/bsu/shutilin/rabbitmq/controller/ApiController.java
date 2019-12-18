package by.bsu.shutilin.rabbitmq.controller;

import by.bsu.shutilin.rabbitmq.util.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    RabbitMqSender rabbitMQSender;

    @GetMapping("/message")
    public void sendMessage(@RequestParam(value = "msg") String msg) {
        rabbitMQSender.send(msg);
    }
}
