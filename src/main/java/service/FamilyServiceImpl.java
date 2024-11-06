package service;

import dao.FamilyDao;
import entity.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyServiceImpl implements FamilyService {
    private final FamilyDao familyDao;

    public FamilyServiceImpl(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    @Override
    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    @Override
    public void getDisplayFamilies() {
        familyDao.getAllFamilies().forEach(System.out::println);
    }

    @Override
    public Optional<List<Family>> getFamiliesBiggerThan(int count) {
        List<Family> familyList = familyDao.getAllFamilies();
        return count <= 0 || familyList.stream().allMatch(family -> family.getCountFamily() < count) ? Optional.empty() :
                Optional.of(familyList.stream().filter(family -> family.getCountFamily() > count).collect(Collectors.toList()));
    }

    @Override
    public Optional<List<Family>> getFamiliesLessThan(int count) {
        List<Family> familyList = familyDao.getAllFamilies();
        return count <= 0 || familyList.stream().allMatch(family -> family.getCountFamily() < count) ? Optional.empty() :
                Optional.of(familyList.stream().filter(family -> family.getCountFamily() < count).collect(Collectors.toList()));
    }

    @Override
    public Optional<Long> countFamiliesWithMemberNumber(int count) {
        List<Family> familyList = familyDao.getAllFamilies();
        return count <= 0 || familyList.stream().allMatch(family -> family.getCountFamily() < count) ? Optional.empty() :
                Optional.of(familyList.stream().filter(family -> family.getCountFamily() == count).count());
    }

    @Override
    public void createNewFamily(Human father, Human mother) {
        Family family = new Family(father, mother);
        familyDao.saveFamily(family);
    }

    @Override
    public void deleteFamilyByIndex(int index) {
        familyDao.deleteFamilyByIndex(index);
    }

    @Override
    public void bornChild(Family family, String maleName, String femaleName) {

        boolean isMan = new Random().nextBoolean();
        String name = isMan ? maleName : femaleName;
        Human bornChild = isMan ? new Man(name, family.getFather().getSurname(),String.valueOf(LocalDate.now()),
                (family.getFather().getIQ() + family.getMother().getIQ()) / 2) :
                new Woman(name, family.getFather().getSurname(), String.valueOf(LocalDate.now()),
                        (family.getFather().getIQ() + family.getMother().getIQ()) / 2);
        family.addChild(bornChild);
        familyDao.saveFamily(family);
    }

    @Override
    public void adoptChild(Family family, Human human) {
        family.addChild(human);
        familyDao.saveFamily(family);

    }

    @Override
    public void deleteAllChildrenOlderThan(int age) {
        List<Family> familyList = familyDao.getAllFamilies();
        LocalDate nowYear = LocalDate.now();

        for (Family family : familyList) {
            List<Human> humanList = family.getChildren().stream().filter(
                    child -> nowYear.getYear() - child.getBirthDate().getYear() < age).toList();
            family.setChildren(humanList);
            familyDao.saveFamily(family);

        }

    }

    @Override
    public int count() {
        return familyDao.getAllFamilies().size();
    }

    @Override
    public Family getFamilyById(int id) {
        return id < 0 || id >= familyDao.getAllFamilies().size() ? null : familyDao.getAllFamilies().get(id);
    }

    @Override
    public Optional<Set<Pet>> getAllPets(int index) {
        return !(index < 0 || index >= familyDao.getAllFamilies().size()) ?
                Optional.of(familyDao.getAllFamilies().get(index).getPet()) : Optional.empty();
    }

    @Override
    public void addPet(int index, Pet pet) {
        if (index < 0 || index >= familyDao.getAllFamilies().size()) {
            return;
        }
        Family family = familyDao.getAllFamilies().get(index);
        Set<Pet> petSet = family.getPet();
        if (petSet == null) {
            petSet = new HashSet<>();
            family.setPet(petSet);
        }
        petSet.add(pet);
        familyDao.saveFamily(family);
    }
}
