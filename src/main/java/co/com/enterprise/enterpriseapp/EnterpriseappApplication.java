package co.com.enterprise.enterpriseapp;

import java.util.*;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import co.com.enterprise.enterpriseapp.config.Constants;



@ComponentScan
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@EnableConfigurationProperties({LiquibaseProperties.class})
public class EnterpriseappApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EnterpriseappApplication.class);
	private final Environment env;
	private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";
	 
	public EnterpriseappApplication(Environment env) {
		this.env=env;
	}
	
	@PostConstruct
	public void initApplication() {
		Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
		
		if(activeProfiles.contains(Constants.SPRING_PROFILE_DEVELOPMENT)) {
			log.info("You are running under '{}'",Constants.SPRING_PROFILE_DEVELOPMENT);
		}
		
	}
	
	public static void main(String[] args) {
		Map<String,Object> preferences=new HashMap<>();
		SpringApplication app=new SpringApplication(EnterpriseappApplication.class);
		
		preferences.put(SPRING_PROFILE_DEFAULT, Constants.SPRING_PROFILE_DEVELOPMENT);
		app.setDefaultProperties(preferences );
		
		Environment env=app.run(args).getEnvironment();
		
		//SpringApplication.run(EnterpriseappApplication.class, args);
		
	}
}
