package CSGFramework.Website;

import java.util.Date;

public class Action {
    private String actionId;
    private int timeActionTakesToPerformInMs;
    private boolean redirectingActions;
    private Page redirectsToPage;
    private double chanceOfActonBeingPerformed;



    Action(String actionId, int timeActionTakesToPerformInMs, boolean redirectingActions, Page redirectsToPage) {
        this.actionId = actionId;
        this.timeActionTakesToPerformInMs = timeActionTakesToPerformInMs;
        this.redirectingActions = redirectingActions;
        this.redirectsToPage = redirectsToPage;
    }

    public boolean isRedirectingActions() {
        return redirectingActions;
    }

    public Page getRedirectsToPage() {
        return redirectsToPage;
    }

    public int getTimeActionTakesToPerformInMs() {
        return timeActionTakesToPerformInMs;
    }

    public String getActionId(){
        return actionId;
    }
}
