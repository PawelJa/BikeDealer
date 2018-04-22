package com.example.cardealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan("com.example.cardealer")
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.example.cardealer.repository")
public class CardealerApplication extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET", "POST", "PUT", "DELETE");// .allowedOrigins("http://localhost");
	}

//	@Bean
//	public LocalEntityManagerFactoryBean entityManagerFactory() {
//		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
//		emfb.setPersistenceUnitName("CarDealerPersistence");
//		return emfb;
//	}
//
//	@Bean
//	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
//		JpaTransactionManager tm = new JpaTransactionManager(emf);
//		return tm;
//	}

	public static void main(String[] args) {
		SpringApplication.run(CardealerApplication.class, args);
	}
}
