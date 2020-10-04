package com.Natwest.Wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAspectJAutoProxy
@EnableDiscoveryClient
@SpringBootApplication
public class WalletApplication {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		WebMvcConfigurer webMvcConfigurer =new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				super.addCorsMappings(registry);
			}
		};
		return webMvcConfigurer;
	}


	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);
	}

}
