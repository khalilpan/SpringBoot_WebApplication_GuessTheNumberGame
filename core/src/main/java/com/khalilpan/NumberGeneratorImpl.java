package com.khalilpan;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // fields
    private final Random random = new Random();

    @Getter
    private final int maxNumber;

    @Getter
    private final int minNumber;

    // == constructor ==
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // methods
    @Override
    public int next() {
        // Example: min=10 max=50 --> max-min=15 -> range (0-40)+min -> range 10-50
        return random.nextInt(maxNumber - minNumber) + minNumber; //generate random number
    }
}
