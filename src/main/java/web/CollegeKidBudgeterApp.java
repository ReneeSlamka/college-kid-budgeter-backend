package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SpringBootApplication
public class CollegeKidBudgeterApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CollegeKidBudgeterApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CollegeKidBudgeterApp.class, args);
    }
}
