package com.RestExOne.TemplateOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/hello")
    public ResponseEntity<String> helloThere( ){
          return  employeeService.hello();
    }

    @GetMapping("/message")
    public ResponseEntity<String> sendMess(@RequestParam String message){
        return employeeService.sendMessage(message);
    }
 @GetMapping("/fanout")
    public ResponseEntity<String> sendFanMess(@RequestParam String message){
        return employeeService.sendFanOut(message);
    }

}
