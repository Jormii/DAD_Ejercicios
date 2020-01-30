package dad.tema1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloWorldApplication {
	
	@Bean
	public UsersService usersService() {
		return new UsersService(15);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	
}
