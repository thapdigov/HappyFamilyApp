package entity;
import java.util.Set;

public abstract class Pet {
    private Species species;
    private String nickName;
    private Integer age;
    private Integer trickLevel;
    private Set<String> habits;

    public Pet() {
    }

    public Pet(Species species, String nickName) {
        this.species = species;
        this.nickName = nickName;
    }

    public Pet(Species species, String nickName, Integer age, Integer trickLevel, Set<String> habits) {
        this.species = species;
        this.nickName = nickName;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(Integer trickLevel) {
        this.trickLevel = trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I am eating...");
    }

    public abstract void respond();

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet object is being remved by Garbage Collector!");
        super.finalize();
    }



    @Override
    public String toString() {
        return species.name() + " { nickName='" + nickName + ", age=" + age +
                ", trickLevel=" + trickLevel + ", habits=" + habits + " ," + species;
    }
}
