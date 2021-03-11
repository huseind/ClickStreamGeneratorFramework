package CSGFramework;

import CSGFramework.Website.Action;
import CSGFramework.Website.Page;

import java.time.LocalDateTime;


public class UserAction {
    private String userId;
    private String actionId;
    private String urlOfPageActionWasPerformedOn;
    private LocalDateTime timeActionWasPerformed;

    public UserAction(String userId, String actionId, String urlOfPageActionWasPerformedOn,LocalDateTime timeActionWasPerformed){
        this.userId = userId;
        this.actionId = actionId;
        this.urlOfPageActionWasPerformedOn = urlOfPageActionWasPerformedOn;
        this.timeActionWasPerformed = timeActionWasPerformed;
    }

    @Override
    public String toString() {
        return userId + " " + actionId + " " + " " + urlOfPageActionWasPerformedOn + " " + timeActionWasPerformed;
    }
}
