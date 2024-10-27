package entity;

import java.time.LocalDate;

public final class Woman extends Human {
    public Woman(String name, String surname, LocalDate year, Integer IQ) {
        super(name, surname, year, IQ);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello my beatiful pet %s!", getPet().getNickName());
    }

    public void makeUp() {
        System.out.println("Being well-groomed is very important for women!");
    }
}
