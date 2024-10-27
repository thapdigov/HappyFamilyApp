package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Family implements HumanCreator {
    private Human father;
    private Human mother;
    private List<Human> children;
    private Set<Pet> pets;
    private final Random random = new Random();

    static {
        System.out.println("Family class is being loaded");
    }

    {
        System.out.println("New Family object is being created");
    }

    public Family(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
        father.setFamily(this);
        mother.setFamily(this);
        children = new ArrayList<>();

    }

    public void addChild(Human child) {
        children.add(child);
    }

    public boolean deletChild(int index) {
        if (index < 0 || index >= children.size()) {
            return false;
        }
        Human child = children.remove(index);
        child.setFamily(null);
        return true;
    }

    public boolean deleteChild(Human human) {
        if (!children.contains(human)) {
            return false;
        }

        Human removeChild = children.get(children.indexOf(human));
        removeChild.setFamily(null);
        return true;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family object is being remved by Garbage Collector!");
        super.finalize();
    }

    @Override
    public Human bornChild() {
        String[] boyNames = {"Karl", "Hulk", "Jord"};
        String[] girlNames = {"Sia", "Mira", "Filoya"};
        boolean isMan = new Random().nextBoolean();
        String name = isMan ? boyNames[random.nextInt(boyNames.length)] : girlNames[random.nextInt(boyNames.length)];
        Integer childIQ = (getFather().getIQ() + getMother().getIQ()) / 2;
        Human human = isMan ? new Man(name, getFather().getSurname(), LocalDate.now(), childIQ) :
                new Woman(name, getFather().getSurname(), LocalDate.now(), childIQ);
        human.setFamily(this);
        return human;
    }

    public Integer getCountFamily() {
        return 2 + children.size();
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPet() {
        return pets;
    }

    public void setPet(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Family {" + "father=%s %s".formatted(father.getName(), father.getSurname())
                + ", mother=%s %s".formatted(mother.getName(), mother.getSurname()) + ", children=" + children + ", pets: " + pets;
    }


}
