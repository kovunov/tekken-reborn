package com.cpan252.tekkenreborn;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.cpan252.tekkenreborn.controller.HomeController;
import com.cpan252.tekkenreborn.model.Fighter;
import com.cpan252.tekkenreborn.model.Fighter.Anime;
import com.cpan252.tekkenreborn.repository.FighterRepository;

/**
 * mvn spring-boot:run does following steps
 * 1. mvn clean
 * 2. mvn compile
 * 3. mvn package
 * 4. java -jar target/tekkenreborn-0.0.1-SNAPSHOT.jar
 * 5. deploys jar to embedded tomcat
 */
@SpringBootApplication
public class TekkenrebornApplication {

	/**
	 * This is the main method that starts the application
	 * Spring Application Context is created here
	 * You can configure your application properties using @param args
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TekkenrebornApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(FighterRepository repository) {
		return args -> {
			repository.save(Fighter.builder()
			.name("Heihachi Mishima")
			.animeFrom(Anime.TEKKEN)
			.damagePerHit(89)
			.health(2000)
			.resistance(new BigDecimal(0.5)).build());

			repository.save(Fighter.builder()
			.name("Kazuya Mishima")
			.animeFrom(Anime.TEKKEN)
			.damagePerHit(86)
			.health(2100)
			.resistance(new BigDecimal(0.5)).build());

			repository.save(Fighter.builder()
			.name("Jin Kazama")
			.animeFrom(Anime.TEKKEN)
			.damagePerHit(90)
			.health(2200)
			.resistance(new BigDecimal(0.5)).build());
			
			repository.save(Fighter.builder()
			.name("Steve Fox")
			.animeFrom(Anime.TEKKEN)
			.damagePerHit(80)
			.health(25000)
			.resistance(new BigDecimal(0.5)).build());
		};
	}

}
