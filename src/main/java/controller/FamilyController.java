package controller;

import entity.Family;
import entity.Human;
import entity.Pet;
import service.FamilyService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FamilyController {
    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<String> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayFamilies() {
        familyService.getDisplayFamilies();
    }

    public Optional<List<Family>> getFamiliesBiggerThan(int count) {
        return familyService.getFamiliesBiggerThan(count);
    }

    public Optional<List<Family>> getFamiliesLessThan(int count) {
        return familyService.getFamiliesLessThan(count);
    }

    public Optional<Long> countFamiliesWithMemberNumber(int count) {
        return familyService.countFamiliesWithMemberNumber(count);
    }

    public void createNewFamily(Human father, Human mother) {
        familyService.createNewFamily(father, mother);
    }

    public void deleteFamilyByIndex(int index) {
        familyService.deleteFamilyByIndex(index);
    }

    public void bornChild(Family family, String maleName, String femaleName) {
        familyService.bornChild(family, maleName, femaleName);
    }

    public void adoptChild(Family family, Human human) {
        familyService.adoptChild(family, human);
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int id) {
        return familyService.getFamilyById(id);
    }

    public Optional<Set<Pet>> getAllPets(int index) {
        return familyService.getAllPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyService.addPet(index, pet);
    }
}
