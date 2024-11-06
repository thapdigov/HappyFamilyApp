package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Man extends Human {


    public Man(String name, String surname, String birthDate, Integer IQ) {
        super(name, surname, birthDate, IQ);
    }

    @Override
    public void greetPet() {
        System.out.printf("Hi my friend %s!", getPet().getNickName());
    }

    public void repairCar() {
        System.out.println("Men's car is cleaner than women's home!");
    }
}
