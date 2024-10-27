package entity;

import java.time.LocalDate;
import java.util.Map;

public class Human {

    private String name;
    private String surname;
    private LocalDate year;
    private Integer IQ;
    private Pet pet;
    private Map<DayOfTheWeek, String> schedule;
    private Family family;


    public Human() {
    }

    public Human(String name, String surname, LocalDate year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }


    public Human(String name, String surname, LocalDate year, Integer IQ, Map<DayOfTheWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.IQ = IQ;
        this.schedule = schedule;
    }

    public Human(String name, String surname, LocalDate year, Integer IQ) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.IQ = IQ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public Integer getIQ() {
        return IQ;
    }

    public void setIQ(Integer IQ) {
        this.IQ = IQ;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Map<DayOfTheWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfTheWeek, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human object is being remved by Garbage Collector!");
        super.finalize();
    }

    public void greetPet() {
        System.out.printf("Hello %s", pet.getNickName());
    }

    public void describePet() {
        String tricklevel = pet.getTrickLevel() > 50 ? "very sly" : "almost not sly";
        System.out.printf("I have an %s is %d years old,he is %s ", pet.getSpecies(), pet.getAge(), tricklevel);
    }

    @Override
    public String toString() {
        return "Human { " + "name='" + name + "', surname='" + surname +
                "', year=" + year + ", IQ=" + IQ + ", schedule= " + schedule;
    }
}
