package com.davidholas.julie;

import com.davidholas.julie.config.JulieMapperConfig;
import com.davidholas.julie.config.JulieSchedulerConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.boot.Banner.Mode.OFF;

@Import({
		JulieMapperConfig.class,
        JulieSchedulerConfig.class
})
@SpringBootApplication
public class JulieApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SpringApplicationBuilder(JulieApplication.class).bannerMode(OFF)
				.build()
				.run(args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/events").allowedOrigins("http://localhost:8090");
				registry.addMapping("/events/**").allowedOrigins("http://localhost:8090");
				registry.addMapping("/persons").allowedOrigins("http://localhost:8090");
				registry.addMapping("/persons/**").allowedOrigins("http://localhost:8090");
				registry.addMapping("/tasks").allowedOrigins("http://localhost:8090");
				registry.addMapping("/tasks/**").allowedOrigins("http://localhost:8090");
			}
		};
	}
}
