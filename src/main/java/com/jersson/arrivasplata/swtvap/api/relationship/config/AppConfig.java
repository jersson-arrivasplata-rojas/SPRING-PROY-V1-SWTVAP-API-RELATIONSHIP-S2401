package com.jersson.arrivasplata.swtvap.api.relationship.config;

import com.jersson.arrivasplata.swtvap.api.relationship.util.UtilityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UtilityService utilityService() {
        return new UtilityService();
    }
}
