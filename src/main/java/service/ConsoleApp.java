package service;

import controller.FamilyController;
import dao.ControllerFamilyDao;
import dao.FamilyDao;

public class ConsoleApp {
    private final FamilyDao familyDao = new ControllerFamilyDao();
    private final FamilyService familyService = new FamilyServiceImpl(familyDao);

    private final FamilyController familyController = new FamilyController(familyService);

    public void run() {


        while (true) {


        }
    }
}