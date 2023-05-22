package com.RestExOne.TemplateOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    private RestTemplate restTemplate;

    @Autowired
    public EmployeeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<String> hello(){
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:9090/api/hello"
        , HttpMethod.GET,null,String.class);
        return response;
    }

    public ResponseEntity<String> sendMessage(String message){
        ResponseEntity<String> response= restTemplate.exchange("http://localhost:9090/api/publish?message="+message,HttpMethod.GET,
                null,String.class);
        return response;
    }

    public ResponseEntity<String> sendFanOut(String message){
        ResponseEntity<String> response=restTemplate.exchange("http://localhost:9090/api/fanout?message="+message,
                HttpMethod.GET,null,String.class);
        return response;
    }


}
