package tech.geekflu.bakery

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.PostgreSQLContainer
import spock.lang.Specification

@ActiveProfiles("test")
class BasicSpecification extends Specification {

    protected static final PostgreSQLContainer postgres;

    static {
        postgres = new PostgreSQLContainer("postgres:9.6.12").withDatabaseName("bakerydb")
                .withUsername("postgres").withPassword("password");
        // Mapped port can only be obtained after container is started.
        postgres.start();
    }

    static class PropertiesInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues
                    .of("spring.datasource.driver-class-name=" + postgres.getDriverClassName(),
                            "spring.datasource.url=" + postgres.getJdbcUrl(),
                            "spring.datasource.username=" + postgres.getUsername(),
                            "spring.datasource.password=" + postgres.getPassword())
                    .applyTo(applicationContext.getEnvironment());
        }
    }

}
