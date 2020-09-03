package br.com.fsrocha.fiisexplorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication( exclude = {SecurityAutoConfiguration.class}) // Security layer not yet implemented
public class FiisexplorerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiisexplorerApplication.class, args);
	}

}
