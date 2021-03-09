package CSGFramework;

import CSGFramework.Website.Action;

import java.time.LocalDateTime;


public class UserAction {
    private User user;
    private Action action;
    private LocalDateTime timeActionWasPerformed;

    public UserAction(User user, Action action, LocalDateTime timeActionWasPerformed){
        this.user = user;
        this.action = action;
        this.timeActionWasPerformed = timeActionWasPerformed;
    }
}
