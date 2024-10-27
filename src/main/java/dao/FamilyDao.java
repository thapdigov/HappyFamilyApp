package dao;

import entity.Family;

import java.util.List;

public interface FamilyDao {


    void saveFamily(Family family);

    Family getFamilyByIndex(int index);

    boolean deleteFamilyByIndex(int index);

    boolean deleteFamily(Family family);

    List<Family> getAllFamilies();
}
