package CoffeeBeans;

import java.util.concurrent.ThreadLocalRandom;

public class GameService {
    private static final int DOORS_COUNT = 3;

    public boolean switchDoorChoice() {
        int doorOfGoat = getDoorOfGoat();
        int doorChoiceOfUser = getDoorChoiceOfUser();

        /*
            (doorOfGoat == doorChoiceOfUser) => should not change door choice
            (doorOfGoat != doorChoiceOfUser) => should not change door choice
        */

        return doorOfGoat != doorChoiceOfUser;
    }

    private int getDoorOfGoat(){
        return randomDoorChoice();
    }

    private int getDoorChoiceOfUser(){
        return randomDoorChoice();
    }

    private int randomDoorChoice(){
        return ThreadLocalRandom.current().nextInt(1, DOORS_COUNT + 1);
    }


}
