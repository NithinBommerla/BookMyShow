package dev.nithin.BookMyShow;

import dev.nithin.BookMyShow.service.InitialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	private InitialisationService initialisationService;
	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting BookMyShowApplication");
		System.out.println("Starting Data Initialization");
		initialisationService.initialise();
	}
}
