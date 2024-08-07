package ro.simavi.mf.avr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Clasa principala de initializare a aplicatiei
 */
@SpringBootApplication
@ComponentScan(
        excludeFilters =
        @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                value = Configuration.class
        )
)
public class StatisticsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StatisticsApplication.class, args);
    }
    
    
}
