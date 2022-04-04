package com.davidholas.julie;

import com.davidholas.julie.config.JulieMapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Import({
		JulieMapperConfig.class
})
@SpringBootApplication
public class JulieApplication {

	public static void main(String[] args) {
		SpringApplication.run(JulieApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/events").allowedOrigins("http://localhost:8090");
				registry.addMapping("/events/**").allowedOrigins("http://localhost:8090");
			}
		};
	}

}
