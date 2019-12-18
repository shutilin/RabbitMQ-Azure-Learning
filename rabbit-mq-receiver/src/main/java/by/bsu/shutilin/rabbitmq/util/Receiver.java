package by.bsu.shutilin.rabbitmq.util;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class Receiver {
    public static final String AZURE_FUNC_URL = "https://azure-functions-archetype-20191211001833850.azurewebsites.net/api/BSUtest-func?code=PdP7LthHUyiPmFagickHHrnxq4ILMYWOXTrvOWQFkJnpCaavSJrGVQ==&name={name}";

    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        this.sendAzureRequest(message);
    }

    private void sendAzureRequest(String message) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(AZURE_FUNC_URL, String.class, message);
        System.out.println(result);
    }
}
