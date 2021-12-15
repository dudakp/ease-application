package sk.fei.tp.ease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
//@EnableNeo4jRepositories
public class EaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(EaseApplication.class, args);
    }

}
