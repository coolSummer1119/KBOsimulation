package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.LegacyPlayerRepository;
import com.example.demo.repository.PlayerRepository;

@Configuration
public class SpringConfig {
	
	private final DataSource dataSource;
	 
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    @Bean
    public PlayerRepository playerRepository() {
		 return new LegacyPlayerRepository(dataSource);
	}
}
