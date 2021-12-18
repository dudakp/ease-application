package sk.fei.tp.ease.spring.mapper;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }
}
