package uz.alex.redisapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties()
@EntityScan(basePackages = "uz.alex.redisapp")
@EnableJpaRepositories(basePackages = "uz.alex.redisapp")
@EnableJpaAuditing
public class RedisAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisAppApplication.class, args);
    }

}
