package sk.fei.tp.ease.spring;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(ServletContext context) {
        return new OpenAPI()
                .info(new Info().title("ease"));
    }
}
