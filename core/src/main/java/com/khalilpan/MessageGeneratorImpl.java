package com.khalilpan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // fields
    private final Game game;

    //constructor
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // init
    @PostConstruct
    public void init() {
        log.info("PostConstruct-value of game {}", game);
    }

    // public methods
    @Override
    public String getMainMessage() {
        return "Number is Between " +
                game.getSmallest() +
                " And " +
                game.getBiggest() +
                ". Can you guess it ? ";
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon()) {
            return "you guessed it ! The number was " + game.getNumber();
        } else if (game.isGameLost()) {
            return "You Lost ! The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid Number Range";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "what is your first guess ?";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "! you have "+game.getRemainingGuesses()+" guess left ";
        }

    }
}
