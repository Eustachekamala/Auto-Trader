package com.eustache.auto_trader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AutoTraderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoTraderApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Auto Trader Application is running";
	}
}
