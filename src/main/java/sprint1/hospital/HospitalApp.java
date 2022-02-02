package sprint1.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalApp {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApp.class, args);
		System.out.println("Hospital Management Started...");
	}
}