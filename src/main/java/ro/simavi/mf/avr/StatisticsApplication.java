package ro.simavi.mf.avr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Clasa principala de initializare a aplicatiei
 */
@SpringBootApplication
public class StatisticsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StatisticsApplication.class, args);
    }
    
    
}
