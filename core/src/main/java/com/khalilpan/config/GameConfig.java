package com.khalilpan.config;

import com.khalilpan.GuessCount;
import com.khalilpan.MaxNumber;
import com.khalilpan.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.khalilpan") //Configures component scanning
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // Fields
    @Value("${game.maxNumber:100}") //to load the values from game.properties // 100 is defauls
    private int maxNumber;

    @Value("${game.guessNumber:10}") //to load the values from game.properties // 10 is  default
    private int guessCount;

    @Value("${game.minNumber:0}") //to load the values from game.properties // 0 is defauls
    private int minNumber;

    // Beans
    @Bean
    @MaxNumber
    public int getMaxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int getGuessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int getMinNumber() {
        return minNumber;
    }
}
