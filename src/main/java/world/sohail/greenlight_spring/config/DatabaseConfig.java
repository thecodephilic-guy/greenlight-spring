package world.sohail.greenlight_spring.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        // Pass raw properties directly to Hikari CP
        config.setJdbcUrl(databaseUrl);
        config.setUsername(databaseUsername);
        config.setPassword(databasePassword);

        // Match Go connection pool settings exactly:
        // maxOpenConns: 25, maxIdleConns: 12, maxIdleTime: 15m, timeout: 5s
        config.setMaximumPoolSize(25);
        config.setMinimumIdle(12);
        config.setIdleTimeout(900_000);     // 15 minutes in ms
        config.setConnectionTimeout(5_000);  // 5 seconds
        config.setPoolName("GreenlightHikariPool");

        return new HikariDataSource(config);
    }
}
