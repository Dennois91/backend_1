package week2.backend_1_week_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Backend1Week2Application {

	public static void main(String[] args) {
		SpringApplication.run(Backend1Week2Application.class, args);
	}
public String HelloWorld(){
		return "HelloWorld";
	}


}
