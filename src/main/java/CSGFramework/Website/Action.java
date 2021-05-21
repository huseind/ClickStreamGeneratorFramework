package CSGFramework.Website;

/**
 * Class that represents an action that can be performed on a website
 *
 */
public class Action {
    private String actionId;
    private int timeActionTakesToPerformInMs;
    private double chanceOfActonBeingPerformed;


    /**
     * package private constructor
     * @param actionId id of the action
     * @param timeActionTakesToPerformInMs the time it takes to perform this action
     * @param chanceOfActonBeingPerformed the change of the action to be performed
     */
    Action(String actionId, int timeActionTakesToPerformInMs, double chanceOfActonBeingPerformed) {
        this.actionId = actionId;
        this.timeActionTakesToPerformInMs = timeActionTakesToPerformInMs;
        this.chanceOfActonBeingPerformed = chanceOfActonBeingPerformed;
    }

    public double getChanceOfActonBeingPerformed() {
        return chanceOfActonBeingPerformed;
    }

    public int getTimeActionTakesToPerformInMs() {
        return timeActionTakesToPerformInMs;
    }

    public String getActionId(){
        return actionId;
    }

    @Override
    public String toString(){
        return actionId;
    }
}
