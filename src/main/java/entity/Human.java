package entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Human {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private Integer IQ;
    private Pet pet;
    private Map<DayOfTheWeek, String> schedule;
    private Family family;


    public Human() {
    }

    public Human(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }


    public Human(String name, String surname, String birthDate, Integer IQ, Map<DayOfTheWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.IQ = IQ;
        this.schedule = schedule;
    }

    public Human(String name, String surname, String birthDate, Integer IQ) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public String describeAge() {
        Period age = Period.between(LocalDate.now(), getBirthDate());
        return String.format("age: %d month: %d day: %d", age.getYears(), age.getMonths(), age.getDays());
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
        return "{ name='" + name + "', surname='" + surname +
                "', birthDate='" + birthDate + "', IQ=" + IQ + ", schedule= " + schedule+" }";
    }
}
