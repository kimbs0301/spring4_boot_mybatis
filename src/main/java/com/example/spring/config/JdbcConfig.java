package com.example.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author gimbyeongsu
 * 
 */
@Configuration
@EnableTransactionManagement
public class JdbcConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(JdbcConfig.class);

	@Autowired
	private Environment environment;

	public JdbcConfig() {
		LOGGER.debug("생성자 JdbcConfig()");
	}

	@Bean(name = "dsData", destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.data.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.data.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.data.password"));
		dataSource.setMaxTotal(5);
		dataSource.setValidationQuery("select 1");
		dataSource.setTestOnBorrow(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(10000);
		dataSource.setMinEvictableIdleTimeMillis(60000);
		dataSource.setMaxWaitMillis(5000);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		// sqlSessionFactory.setConfiguration(configuration());
		sqlSessionFactory.setDatabaseIdProvider(databaseIdProvider());
		ClassPathResource configLocation = new ClassPathResource("mybatis/config-data.xml");
		sqlSessionFactory.setConfigLocation(configLocation);
		return sqlSessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sqlSessionTemplate;
	}

	// private org.apache.ibatis.session.Configuration configuration() {
	// org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
	// configuration.setMapUnderscoreToCamelCase(false);
	// return configuration;
	// }

	private VendorDatabaseIdProvider databaseIdProvider() {
		VendorDatabaseIdProvider vendorDatabaseIdProvider = new VendorDatabaseIdProvider();
		Properties properties = new Properties();
		properties.setProperty("MySQL", "mysql");
		vendorDatabaseIdProvider.setProperties(properties);
		return vendorDatabaseIdProvider;
	}
}
