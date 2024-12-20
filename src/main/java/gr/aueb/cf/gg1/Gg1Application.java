package gr.aueb.cf.gg1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Gg1Application {

    public static void main(String[] args) {
        SpringApplication.run(Gg1Application.class, args);
    }

}
