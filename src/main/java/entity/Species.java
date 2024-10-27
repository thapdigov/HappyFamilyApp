package entity;

public enum Species {
    DOG(false, 4, true),
    CAT(false, 4, true),
    BIRD(true, 2, true),
    FISH(false, 0, false),
    UNKNOWN();

    private boolean canFly;
    private Integer countOfLegs;
    private boolean hasfur;


    Species(boolean canFly, Integer countOfLegs, boolean hasfur) {
        this.canFly = canFly;
        this.countOfLegs = countOfLegs;
        this.hasfur = hasfur;
    }

    Species() {
    }

    public static Species getSpecies(String text) {
        Species[] species = Species.values();

        for (Species value : species) {
            if (value.name().equals(text)) {
                return value;
            }
        }
        return Species.UNKNOWN;

    }

    @Override
    public String toString() {
        return "Species{" +
                "canFly=" + canFly +
                ", countOfLegs=" + countOfLegs +
                ", hasfur=" + hasfur +
                '}';
    }
}
