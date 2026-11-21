package com.escapees.my_room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRoomApplication.class, args);
	}

}
