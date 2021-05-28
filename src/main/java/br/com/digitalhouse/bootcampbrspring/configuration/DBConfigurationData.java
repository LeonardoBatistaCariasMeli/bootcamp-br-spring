package br.com.digitalhouse.bootcampbrspring.configuration;

import br.com.digitalhouse.bootcampbrspring.configuration.service.DBService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfigurationData {
    private DBService dbService;

    public DBConfigurationData(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public boolean instantiateDatabase() {
        dbService.InstantiateH2Database();
        return true;
    }
}
