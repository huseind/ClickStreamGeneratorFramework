package CSGFramework.User;

import CSGFramework.Website.Action;
import CSGFramework.Website.Webpage;

import javax.swing.text.html.HTMLDocument;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Class representing a user
 */
public class User {
    private String id;
    private List<UserAction> performedActions = new ArrayList<>();
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
        // MAYBE REMOVE???
        /*if(action.isRedirectingActions()){
            currentViewingWebpage = action.getRedirectsToPage();
        }
        // creates a new userAction
        // timeActionWasPerformed is equal to now + the time it takes to perform
        performedActions.add(new UserAction(this.id, action.getActionId(),currentViewingWebpage.getUrl(),LocalDateTime.now().plusSeconds(action.getTimeActionTakesToPerformInMs()/1000)));
        */
    }

    // new before final
    /**
     * Method for a user to perform a set number of actions.
     * Starts at home page and does and action, if the action is redirecting, currentViewingPage changes
     * @param numberOfActionsToPerform
     */
    public void perform(int numberOfActionsToPerform){
        for(int i = 0; i < numberOfActionsToPerform; i ++){
            HashMap<Action,Webpage> actions = currentViewingWebpage.getPossibleActions();
            Iterator iterator = actions.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                Action performedAction = (Action) pair.getKey();
                performedActions.add(new UserAction(this.id,performedAction.getActionId(),currentViewingWebpage.getUrl(), LocalDateTime.now()));
                if(pair.getValue() != null){
                    currentViewingWebpage = (Webpage) pair.getValue();
                }

            }
        }
        for (UserAction action:performedActions) {
            System.out.println("WOOP " +action.toString());
        }
    }

    @Override
    public String toString(){
        return id;
    }


}
