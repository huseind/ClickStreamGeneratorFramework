package CSGFramework;

import CSGFramework.Website.Action;
import CSGFramework.Website.Page;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Class representing a user
 */
public class User {
    private String id;
    private List<UserAction> performedActions;
    private Page currentViewingPage;
    private List<Page> vistitedPages;



    // CONSTRUCTORS //
    public User(String id) { this.id = id; }


    public void performAction(Action action) {
        //TODO: Here we should check if this action exists on the current page
        if(action.isRedirectingActions()){
            currentViewingPage = action.getRedirectsToPage();
        }
        // creates a new userAction
        // timeActionWasPerformed is equal to now + the time it takes to perform
        performedActions.add(new UserAction(this, action, LocalDateTime.now().plusSeconds(action.getTimeActionTakesToPerformInMs()/1000)));
    }


}
