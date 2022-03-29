package com.davidholas.julie.config;

import com.davidholas.julie.web.mapping.EventMapper;
import com.davidholas.julie.web.mapping.EventMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JulieMapperConfig {

    @Bean
    public EventMapper eventMapper() {
        return new EventMapperImpl();
    }
}
