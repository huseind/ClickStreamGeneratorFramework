package CSGFramework.Website;

import java.util.Date;

public class Action {
    private String actionId;
    private int timeActionTakesToPerformInMs;
    private double chanceOfActonBeingPerformed;



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
