package CSGFramework.User;

import java.time.LocalDateTime;


public class UserAction {
    private String userId;
    private String actionId;
    private String urlOfPageActionWasPerformedOn;
    private String urlRedirectedTo;
    private LocalDateTime timeActionWasPerformed;

    public UserAction(String userId, String actionId, String urlOfPageActionWasPerformedOn, String urlRedirectedTo,LocalDateTime timeActionWasPerformed){
        this.userId = userId;
        this.actionId = actionId;
        this.urlOfPageActionWasPerformedOn = urlOfPageActionWasPerformedOn;
        this.urlRedirectedTo = urlRedirectedTo;
        this.timeActionWasPerformed = timeActionWasPerformed;
    }

    @Override
    public String toString() {
        System.out.println(userId);
        return userId + " " + actionId + " " + urlOfPageActionWasPerformedOn + " " + urlRedirectedTo +  " " + timeActionWasPerformed;
    }

    String getActionId(){
        return actionId;
    }
}
