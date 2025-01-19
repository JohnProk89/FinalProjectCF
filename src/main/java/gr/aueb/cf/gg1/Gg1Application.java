package gr.aueb.cf.gg1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Gg1Application {

    // Δημιουργία Logger
    private static final Logger logger = LoggerFactory.getLogger(Gg1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Gg1Application.class, args);

        // Μήνυμα που δείχνει ότι η εφαρμογή έφτασε στο 80%
        logger.info("Application has reached 80% of execution.");
    }
}