package dao;

import entity.Family;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControllerFamilyDao implements FamilyDao {

    private final List<Family> familyList = new ArrayList<>();

    @Override
    public void saveFamily(Family family) {
        if (!familyList.contains(family)) {
            familyList.add(family);
        } else {
            System.out.println("Family is already contains!");
        }
    }

    @Override
    public Optional<Family> getFamilyByIndex(int index) {
        return index < 0 || index >= familyList.size() ? Optional.empty() : Optional.of(familyList.get(index));
    }

    @Override
    public boolean deleteFamilyByIndex(int index) {
        if (index < 0 || index >= familyList.size()) {
            return false;
        } else {
            familyList.remove(index);
            return true;
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        if (!familyList.contains(family)) {
            return false;
        } else {
            familyList.remove(family);
            return true;
        }
    }

    @Override
    public List<Family> getAllFamilies() {
        return familyList;
    }


}
