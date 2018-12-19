package com.khalilpan.console;

import com.khalilpan.Game;
import com.khalilpan.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {

    //Fields
    private final Game game;

    private final MessageGenerator messageGenerator;

    // == constructor ==
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //Events
    @EventListener(ContextRefreshedEvent.class)
    public void Start() {
        log.info("Start() --> Container is ready to use.");

        Scanner scanner=new Scanner(System.in);

        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess=scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play Again y/n?");

                String playAgainResult = scanner.nextLine().trim();
                if (!playAgainResult.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }


        }
    }
}
