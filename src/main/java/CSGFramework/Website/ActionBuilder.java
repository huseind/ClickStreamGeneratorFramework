package CSGFramework.Website;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Builder for the action class
 */
public class ActionBuilder {
    private String actionId = generateRandomActionId();
    private int timeActionTakesToPerformInMs =  generateRandomInt();
    private double chanceOfActonBeingPerformed = (Math.random() + 0.01);

    // new before final
    private static List<String> alreadyGeneratedIds = new ArrayList<>();


    public ActionBuilder setChanceOfActonBeingPerformed(double chanceOfActonBeingPerformed) {
        this.chanceOfActonBeingPerformed = chanceOfActonBeingPerformed;
        return this;
    }

    /**
     * Method for generating random actioid,
     * does not generate identical ids
     * @return
     */
    private String generateRandomActionId(){ //TODO: Should not create two equal strings

        String listOfCharFor = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
        String returnString = "";

        for (int i = 0; i < 3; i++) {

            // generate a random char and number between
            // 0 to listOfCharFor variable length
            int index = (int) (Math.random() * 36);

            // add Character one by one in end of returnString
            returnString += listOfCharFor.charAt(index);
        }
         if (alreadyGeneratedIds.contains(returnString.toString())){
            return generateRandomActionId();
        }
        return returnString;
    }


    /**
     * Method used in generating random actionID, used to set timeToPerformAction();
     * @return a random int between 10, 1000
     */
    private int generateRandomInt(){
        return ThreadLocalRandom.current().nextInt(100, 10000 + 1);
    }

    /**
     * Sets the id of the action
     * @param actionId String, the id of the action
     * @return this instance of the builder
     */
    public ActionBuilder setActionId(String actionId) {
        this.actionId = actionId;
        return this;
    }

    /**
     * sets time it takes to perform the action
     * @param timeActionTakesToPerformInMs int, the time in ms it takes to perform the action
     * @return this instance of the builder
     */
    public ActionBuilder setTimeActionTakesToPerformInMs(int timeActionTakesToPerformInMs) {
        this.timeActionTakesToPerformInMs = timeActionTakesToPerformInMs;
        return this;
    }


    /**
     * builds an instance of an action
     * @return Action with all the values set
     */
    public Action build(){
        return new Action(actionId,timeActionTakesToPerformInMs,chanceOfActonBeingPerformed);
    }
}
