package entity;

import java.util.Set;

public class Fish extends Pet {
    public Fish(Species species, String nickName, Integer age, Integer trickLevel, Set<String> habits) {
        super(species, nickName, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        {
            System.out.printf("I am a fish %s,I swim in the sea.I miss you!", getNickName());
        }
    }
}

