package by.bsu.shutilin.rabbitmq.util;

import by.bsu.shutilin.rabbitmq.RabbitMqApplication;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        System.out.println("Sending message...");
        System.out.println(rabbitTemplate);
        rabbitTemplate.convertAndSend("spring-boot-exchange", "by.bsu.test", message);
    }
}
