package CSGFramework.User;

import java.time.LocalDateTime;

/**
 * A class that lets us custimize what we want to log in our clickstreamdata
 */
public class UserActionBuilder {
    private String userId;
    private String actionId;
    private String urlOfPageActionWasPerformedOn;
    private LocalDateTime timeActionWasPerformed;

    public UserActionBuilder setUser(String userId) {
        this.userId = userId;
        return this;
    }

    public UserActionBuilder setAction(String actionId) {
        this.actionId = actionId;
        return this;
    }

    public UserActionBuilder setPageActionWasPerformedOn(String urlOfPageActionWasPerformedOn) {
        this.urlOfPageActionWasPerformedOn = urlOfPageActionWasPerformedOn;
        return this;
    }

    public UserActionBuilder setTimeActionWasPerformed(LocalDateTime timeActionWasPerformed) {
        this.timeActionWasPerformed = timeActionWasPerformed;
        return this;
    }


    public UserAction build(){
        return new UserAction(userId,actionId,urlOfPageActionWasPerformedOn,timeActionWasPerformed);
    }
}
