package com.davidholas.julie;

import com.davidholas.julie.config.JulieMapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({
		JulieMapperConfig.class
})
@SpringBootApplication
public class JulieApplication {

	public static void main(String[] args) {
		SpringApplication.run(JulieApplication.class, args);
	}

}
