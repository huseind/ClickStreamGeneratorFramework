package CSGFramework.Website;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ActionBuilder {
    private String actionId = generateRandomActionId();
    private int timeActionTakesToPerformInMs = generateRandomInt();
    private double chanceOfActonBeingPerformed = 0.5;

    // new before final
    private static List<String> alreadyGeneratedIds = new ArrayList<>();





    /**
     * Method for generating random actioid,
     * It checks if
     * @return
     */
    private String generateRandomActionId(){ //TODO: Should not create two equal strings

        String listOfCharFor = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
        StringBuilder stringBuilder = new StringBuilder(3);

        for (int i = 0; i < 3; i++) {

            // generate a random number between
            // 0 to listOfCharFor variable length
            int index = (int)(listOfCharFor.length() * Math.random());

            // add Character one by one in end of stringBuilder
            stringBuilder.append(listOfCharFor
                    .charAt(index));
        }
        if (alreadyGeneratedIds.contains(stringBuilder.toString())){
            return generateRandomActionId();
        }
        return stringBuilder.toString();
    }


    /**
     * Method used in generating random actionID, used to set timeToPerformAction();
     * @return a random int between 10, 1000
     */
    private int generateRandomInt(){
        return ThreadLocalRandom.current().nextInt(10, 1000 + 1);
    }


    public ActionBuilder setActionId(String actionId) {
        this.actionId = actionId;
        return this;
    }

    public ActionBuilder setTimeActionTakesToPerformInMs(int timeActionTakesToPerformInMs) {
        this.timeActionTakesToPerformInMs = timeActionTakesToPerformInMs;
        return this;
    }


    public Action build(){
        return new Action(actionId,timeActionTakesToPerformInMs,chanceOfActonBeingPerformed);
    }
}
