package personasbeans.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ClasePersona creaClasePersona1() {
        return new ClasePersona("bean1");
    }

    @Bean
    public ClasePersona creaClasePersona2() {
        return new ClasePersona("bean2");
    }

    @Bean
    ClasePersona creaClasePersona3() {
        return new ClasePersona("bean3");
    }
}