package com.example.ibi.challenge;

import com.example.ibi.challenge.model.Country;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@ExtendWith(MockitoExtension.class)
public class AbstractTest {

    private final Faker faker = new Faker();

    protected final Faker faker() {return faker;}

    protected Country anyCountry() {
        Country command = new Country();
        command.setId(ThreadLocalRandom.current().nextLong(10, 100));
        command.setName(faker.address().country());
        command.setCapital(faker.address().city());
        command.setRegion(faker.lorem().word());
        command.setSubRegion(faker.lorem().word());
        command.setArea(ThreadLocalRandom.current().nextDouble());
        return command;
    }
}
