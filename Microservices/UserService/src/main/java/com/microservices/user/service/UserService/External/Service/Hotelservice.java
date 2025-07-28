package com.microservices.user.service.UserService.External.Service;

import com.microservices.user.service.UserService.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")// calling hotel service
public interface Hotelservice {

    @GetMapping("/hotels/get/{id}")
        public Hotel getHotel(@PathVariable int id);

}
