package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RoomBooking {

	public static void main(String[] args) {
		SpringApplication.run(RoomBooking.class, args);
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello world";
	}
}
