package CSGFramework.Website;

import java.util.Date;

public class Action {
    private String actionId; // can be name
    private String result; // result of action UNNECESSARY?
    private int timeActionTakesToPerformInMs;
    private boolean actionPerformed = false;
    //private Date timeWhenActionWasPerformed;
    private boolean redirectingActions;
    private Page redirectsToPage;

    private Page redirectsTo;


    // CONSTRUCTORS //
    public Action(){
        //empty constructor
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
}
