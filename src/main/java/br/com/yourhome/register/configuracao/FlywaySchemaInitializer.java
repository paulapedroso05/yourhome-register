package br.com.yourhome.register.configuracao;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
public class FlywaySchemaInitializer {

    private final DataSource dataSource;

    @PostConstruct
    public void migrateFlyway() {
        Flyway.configure().dataSource(dataSource).load().migrate();
    }

}
