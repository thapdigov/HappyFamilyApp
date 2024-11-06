package entity;

import java.time.LocalDate;

public final class Woman extends Human {
    public Woman(String name, String surname, String birthDate, Integer IQ) {
        super(name, surname, birthDate, IQ);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hello my beatiful pet %s!", getPet().getNickName());
    }

    public void makeUp() {
        System.out.println("Being well-groomed is very important for women!");
    }
}
