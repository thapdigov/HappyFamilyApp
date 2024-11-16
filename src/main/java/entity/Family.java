package entity;

import java.time.LocalDate;
import java.util.*;

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
        Human human = isMan ? new Man(name, getFather().getSurname(), String.valueOf(LocalDate.now()), childIQ) :
                new Woman(name, getFather().getSurname(), String.valueOf(LocalDate.now()), childIQ);
        human.setFamily(this);
        return human;
    }

    public String prettyFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("family: \n");
        stringBuilder.append("\t\tmother: ").append(mother.toString()).append(",\n");
        stringBuilder.append("\t\tfather: ").append(father.toString()).append(",\n\t\tchildren:\n");
        for (Human child : children) {
            String gender = child instanceof Man ? "boy: " : "girl: ";
            stringBuilder.append(" \t\t\t\t").append(gender).append(child).append(",\n");
        }
        stringBuilder.append("\t\tpets: ").append(pets);
        return stringBuilder.toString();
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

//    @Override
//    public String toString() {
//        return "family: {" + "\n\t\tmother: {name='%s', surname='%s'}".formatted(mother.getName(), mother.getSurname()) +
//                "\n\t\tfather:{%s %s}".formatted(father.getName(), father.getSurname())
//                + "\n\t\tchildren: " + children + "\n\t\tpets: " + pets;
//    }


    @Override
    public String toString() {
        return "Family{" +
                "father=" + father +
                ", mother=" + mother +
                ", children=" + children +
                ", pets=" + pets +
                '}';
    }
}
