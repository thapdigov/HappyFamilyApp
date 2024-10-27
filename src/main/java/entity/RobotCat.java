package entity;

import java.util.Set;

public class RobotCat extends Pet {
    public RobotCat(Species species, String nickName, Integer age, Integer trickLevel, Set<String> habits) {
        super(species, nickName, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.printf("I am %s. I miss you!", getNickName());
    }
}
