package entity;

import java.util.Set;

public class Dog extends Pet implements Foul {
    public Dog(Species species, String nickName, Integer age, Integer trickLevel, Set<String> habits) {
        super(species, nickName, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        {
            System.out.printf("Hav Hav Hav,I am %s. I miss you!", getNickName());
        }
    }

    @Override
    public void foul() {
        System.out.println("I need to cover up!");
    }
}

