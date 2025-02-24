package co.edu.uniquindio.zugarez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ZugarezApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZugarezApplication.class, args);
    }

}
