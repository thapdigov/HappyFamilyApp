package entity;

import java.time.LocalDate;

public final class Man extends Human {
    public Man(String name, String surname, LocalDate year, Integer IQ) {
        super(name, surname, year, IQ);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hi my friend %s!", getPet().getNickName());
    }

    public void repairCar() {
        System.out.println("Men's car is cleaner than women's home!");
    }
}
