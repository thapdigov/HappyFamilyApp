package dao;

import entity.Family;

import java.util.List;
import java.util.Optional;

public interface FamilyDao {


    void saveFamily(Family family);

    Optional<Family>getFamilyByIndex(int index);

    boolean deleteFamilyByIndex(int index);

    boolean deleteFamily(Family family);

    List<Family> getAllFamilies();
}
