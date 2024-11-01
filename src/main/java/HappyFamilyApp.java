import entity.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HappyFamilyApp {
    public static void main(String[] args) {

        Map<DayOfTheWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfTheWeek.MONDAY, "Go to the fitness");
        schedule.put(DayOfTheWeek.TUESDAY, "Read a book");
        Set<String> habits=new HashSet<>();
        habits.add("eat");
        habits.add("sleep");

        Human father = new Human("Emil", "Tapdigov", LocalDate.parse("1978-07-14"));
        Human mother = new Human("Samira", "Mahmudova", LocalDate.parse("1982-04-05"));
        Human child = new Human("Sanan", "Tapdigov", LocalDate.parse("2002-09-22"), 80, schedule);
        Pet pet = new Dog(Species.DOG, "Rex", 3, 75, habits);
        Set<Pet>pets=new HashSet<>();
        pets.add(pet);
        Family family = new Family(father, mother);
        family.setPet(pets);
        family.addChild(child);
        System.out.println(family);


    }
}
