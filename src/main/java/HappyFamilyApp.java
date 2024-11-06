import entity.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HappyFamilyApp {
    public static void main(String[] args) {

        Map<DayOfTheWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfTheWeek.MONDAY, "Go to the fitness");
        schedule.put(DayOfTheWeek.TUESDAY, "Read a book");
        Set<String> habits = new HashSet<>();
        habits.add("eat");
        habits.add("sleep");

        Human father = new Human("Jord", "Baydon", "14/07/1978");
        Human mother = new Human("Mila", "Baydon", "05/04/1982");
        Human child = new Human("Fred", "Baydon", "22/08/2002", 80, schedule);
        Pet pet = new Dog(Species.DOG, "Rex", 3, 75, habits);
        Set<Pet> pets = new HashSet<>();
        pets.add(pet);
        Family family = new Family(father, mother);
        family.setPet(pets);
        family.addChild(child);
        System.out.println(family);
        System.out.println(father.describeAge());


    }
}
