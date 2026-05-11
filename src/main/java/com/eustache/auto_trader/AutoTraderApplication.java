package com.eustache.auto_trader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eustache.auto_trader.Entity.Address;
import com.eustache.auto_trader.Entity.User;
import com.eustache.auto_trader.Helpers.Role;
import com.eustache.auto_trader.Repository.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class AutoTraderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoTraderApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository) {

		return args -> {

			System.out.println("Auto Trader Application is running on port 8080");

			if (userRepository.count() > 0) {
				return;
			}

			Faker faker = new Faker();

			for (int i = 0; i < 5; i++) {

				User user = User.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.email(faker.internet().emailAddress())
						.password(faker.internet().password())
						.phoneNumber(faker.phoneNumber().cellPhone())
						.role(Role.USER)
						.addresses(new ArrayList<>())
						.build();

				List<Address> addresses = new ArrayList<>();

				// Create multiple addresses for one user
				for (int j = 0; j < 3; j++) {

					Address address = Address.builder()
							.street(faker.address().streetAddress())
							.city(faker.address().city())
							.zipCode(faker.address().zipCode())
							.user(user)
							.build();

					addresses.add(address);
				}

				user.setAddresses(addresses);

				userRepository.save(user);
			}

			System.out.println("5 users with multiple addresses have been created");
		};
	}
}