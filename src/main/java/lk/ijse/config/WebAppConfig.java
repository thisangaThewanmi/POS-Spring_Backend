package lk.ijse.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse")
@EnableWebMvc
//to get the true power of a Speing web mvc application
public class WebAppConfig {
}
