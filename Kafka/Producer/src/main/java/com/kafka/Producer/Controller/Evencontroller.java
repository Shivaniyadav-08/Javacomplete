package com.kafka.Producer.Controller;


import com.kafka.Producer.Pojo.Customer;
import com.kafka.Producer.Service.msgPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class Evencontroller {

    @Autowired
    private msgPublisher msgPublisher;

    @PostMapping("/save/{msg}")
    public ResponseEntity<?> publicMsg(@PathVariable String msg){
      try {
          for (int i=0; i<10;i++){
              msgPublisher.sendMessage(msg+" "+i);
          }
          return ResponseEntity.ok("Published Succesfullly");
      }catch (Exception ex){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
      }
    }

    @PostMapping("/publish")
    public void publicEvent(@RequestBody Customer customer){
        msgPublisher.sendEventToTopic(customer);

    }
}
