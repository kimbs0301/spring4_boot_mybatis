package com.example.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author gimbyeongsu
 * 
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RootConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(RootConfig.class);

	@Autowired
	private Environment environment;
	@Autowired
	private ObjectMapper objectMapper;

	public RootConfig() {
		LOGGER.debug("생성자 RootConfig()");
	}

	@Bean(name = "configProperties")
	public PropertiesFactoryBean configProperties() {
		PropertiesFactoryBean properties = new PropertiesFactoryBean();
		String[] profiles = environment.getActiveProfiles();
		ClassPathResource[] classPathResources = new ClassPathResource[profiles.length];
		for (int i = 0; i < profiles.length; ++i) {
			String profile = profiles[i];
			if ("junit".equals(profile) || "local".equals(profile)) {
				classPathResources[i] = new ClassPathResource("application-" + profiles[i] + ".properties");
			} else {
				classPathResources[i] = new ClassPathResource("config/application-" + profiles[i] + ".properties");
			}
		}
		properties.setLocations(classPathResources);
		return properties;
	}

	@Bean(name = "objectMapper")
	public ObjectMapper objectMapper() {
		ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return om;
	}
}