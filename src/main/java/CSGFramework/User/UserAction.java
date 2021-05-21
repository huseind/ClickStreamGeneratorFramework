package CSGFramework.User;

import java.time.LocalDateTime;

/**
 * Class that represents the data that is generated
 */
public class UserAction {
    private String userId;
    private String actionId;
    private String urlOfPageActionWasPerformedOn;
    private String urlRedirectedTo;
    private LocalDateTime timeActionWasPerformed;

    /**
     * package private constructor
     * @param userId the id of the user
     * @param actionId the id of the action performed
     * @param urlOfPageActionWasPerformedOn url of the page the action was performed on
     * @param urlRedirectedTo url of the page the action redirects to, null if not redirecting action
     * @param timeActionWasPerformed the date and time of when the action was performed
     */
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
