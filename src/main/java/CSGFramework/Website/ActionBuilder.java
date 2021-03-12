package CSGFramework.Website;

import java.util.concurrent.ThreadLocalRandom;

public class ActionBuilder {
    private String actionId = generateRandomActionId();
    private int timeActionTakesToPerformInMs = generateRandomInt();
    private boolean redirectingActions = false;
    private Page redirectsToPage = null;










    /**
     * Method for generating random actioid
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
        return stringBuilder.toString();
    }

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

    public ActionBuilder setRedirectingActions(boolean redirectingActions) {
        this.redirectingActions = redirectingActions;
        return this;
    }

    public ActionBuilder setRedirectsToPage(Page redirectsToPage) {
        this.redirectsToPage = redirectsToPage;
        return this;
    }

    public Action build(){
        return new Action(actionId,timeActionTakesToPerformInMs,redirectingActions,redirectsToPage);
    }
}
