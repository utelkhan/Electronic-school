package kz.greetgo.eschool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class ESchoolApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ESchoolApplication.class, args);
    }
    @Override
    public void run(String... args){
        System.out.println("|\n|\n|\n|\n|\n===================================================================================================================================================");
        log.info( "\"Electronic school\" application was successfully created!!!");
        System.out.println("===================================================================================================================================================");
    }
}
