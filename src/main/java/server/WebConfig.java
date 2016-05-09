package server;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages = {"server.web", "server.service"})
//@ComponentScan(basePackageClasses = {WebController.class, AccountService.class})
@EnableWebMvc

public class WebConfig {

}
