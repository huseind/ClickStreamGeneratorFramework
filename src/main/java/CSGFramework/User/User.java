package CSGFramework.User;

import CSGFramework.Website.Action;
import CSGFramework.Website.Webpage;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Class representing a user
 */
public class User {
    private String id;
    private List<UserAction> performedActions;
    private Webpage currentViewingWebpage;
    private List<Webpage> vistitedWebpages; // IS THIS NECCESARY?!?!?!?!



    // CONSTRUCTORS //
    User(String id) { this.id = id; }

    /**
     * User constuctor
     * @param id userID
     * @param currentViewingWebpage the page the user is currently on
     */
    User(String id, Webpage currentViewingWebpage) { this.id = id; this.currentViewingWebpage = currentViewingWebpage;}


    public void setCurrentViewingWebpage(Webpage currentViewingWebpage) {
        this.currentViewingWebpage = currentViewingWebpage;
    }

    /**
     * Method that makes a user perform an action, a action is added to the user list of performed actions
     * @param action
     */
    public void performAction(Action action) {
        //TODO: Here we should check if this action exists on the current page
        /*if(action.isRedirectingActions()){
            currentViewingWebpage = action.getRedirectsToPage();
        }
        // creates a new userAction
        // timeActionWasPerformed is equal to now + the time it takes to perform
        performedActions.add(new UserAction(this.id, action.getActionId(),currentViewingWebpage.getUrl(),LocalDateTime.now().plusSeconds(action.getTimeActionTakesToPerformInMs()/1000)));
        */
    }

    @Override
    public String toString(){
        return id;
    }


}
