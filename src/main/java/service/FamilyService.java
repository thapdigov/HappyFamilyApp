package service;

import entity.Family;
import entity.Human;
import entity.Pet;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FamilyService {

    List<String> getAllFamilies();

    void getDisplayFamilies();

    Optional<List<Family>> getFamiliesBiggerThan(int number);

    Optional<List<Family>> getFamiliesLessThan(int number);

    Optional<Long> countFamiliesWithMemberNumber(int number);

    void createNewFamily(Human father, Human mother);

    void deleteFamilyByIndex(int index);

    void bornChild(Family family, String maleName, String femaleName);

    void adoptChild(Family family, Human human);

    void deleteAllChildrenOlderThan(int age);

    int count();

    Family getFamilyById(int id);

    Optional<Set<Pet>> getAllPets(int index);

    void addPet(int index, Pet pet);
}
