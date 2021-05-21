package CSGFramework.User;

import CSGFramework.Website.Action;
import CSGFramework.Website.Webpage;
import CSGFramework.Website.Website;

import javax.swing.text.html.HTMLDocument;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Class representing a user
 * User performs Actions and generates userActions
 */
public class User {
    private String id;
    private List<UserAction> performedActions = new ArrayList<>();
   // private Webpage currentViewingWebpage;
    private List<Webpage> vistitedWebpages = new ArrayList<>(); // IS THIS NECCESARY?!?!?!?!
    private List<Webpage> breadcrumbs = new ArrayList<>();
    private Webpage previousWebpage;


    // CONSTRUCTORS //
    User(String id) { this.id = id; }

    /**
     * User constuctor, adds current viewing page to visited pages
     * @param id userID
     * @param currentViewingWebpage the page the user is currently on
     */
    User(String id, Webpage currentViewingWebpage) { this.id = id; breadcrumbs.add(currentViewingWebpage);}

    /**
     * sets the currently viewing page for the user.
     * @param currentViewingWebpage the page the user the user is currently viewing
     */
    public void setCurrentViewingWebpage(Webpage currentViewingWebpage) {
        vistitedWebpages.add(currentViewingWebpage);
        breadcrumbs.add(currentViewingWebpage);
    }


    // new before final
    /**
     * Method for a user to perform a set number of actions.
     * Starts at home page and does and action, if the action is redirecting, currentViewingPage changes
     * Will not perform numberOfActionsToPerform if the website does not contain enough actions!
     * @param numberOfActionsToPerform int, number of actions the user should perform
     */
    public List<UserAction> perform(int numberOfActionsToPerform){
        // start time for performing actions
        long now = System.currentTimeMillis();
        for(int i = 0; i < numberOfActionsToPerform; i ++){
            // available actions on webpage
            //HashMap<Action,Webpage> actions = new HashMap<>(currentViewingWebpage.getPossibleActions());
            HashMap<Action,Webpage> actions = new HashMap<>(breadcrumbs.get(breadcrumbs.size()-1).getPossibleActions());
            Iterator iterator = actions.entrySet().iterator();
            Action nextActionToPerform = null;
            Webpage webpage = null;

            // checking if there are possible actions(already performed or empty) if not, go back to previous page.
            if(actions.size() < 1 && i != 0){
                if(breadcrumbs.size() > 1){
                    performedActions.add(new UserAction(this.id, "Return Action", breadcrumbs.get(breadcrumbs.size()-1).getUrl(),breadcrumbs.get(breadcrumbs.size()-2).getUrl(), LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault())));
                    goBack();
                }
            }
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                Action action = (Action) pair.getKey();
                now = now + action.getTimeActionTakesToPerformInMs();

                    if(!isActionAlreadyPerformed(action)) {
                        if (nextActionToPerform == null) {
                            nextActionToPerform = action;
                        } else if (nextActionToPerform.getChanceOfActonBeingPerformed() < action.getChanceOfActonBeingPerformed()) {
                            nextActionToPerform = action;
                            webpage = (Webpage) pair.getValue();
                        }
                    }
                }

            // if we have not performed that action, perform it
            if (nextActionToPerform != null) {
                performedActions.add(new UserAction(
                        this.id, nextActionToPerform.getActionId(),
                        breadcrumbs.get(breadcrumbs.size()-1).getUrl(),webpage == null ?  null : webpage.getUrl(),
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault())));
                actions.remove(nextActionToPerform);
                // redirect if its a redirecting action
                if (webpage != null) {
                    visitPage(webpage);
                }
            }
        }

        return performedActions;
    }

    /**
     * private method to visit a page with the user
     * called when a page needs to be added to viewed page and breadcrumbs
     * @param webpage the page to visti
     */
    private void visitPage(Webpage webpage) {
        breadcrumbs.add(webpage);
        if(!vistitedWebpages.contains(webpage)) {
            vistitedWebpages.add(webpage);
        }
    }

    /**
     * User vil visit every redirecting route in the website
     * @param website the website to exhaust all routes on
     * @return a list of user actions
     */
    public List<UserAction> exhaustAllRoutes(Website website){
        //currentViewingWebpage = website.getHomeWebpage();
        List<Webpage> allPages = website.getAllWebpages();
        long now = System.currentTimeMillis();
        while(vistitedWebpages.size() < allPages.size()){
            HashMap<Action,Webpage> actions = new HashMap<>(breadcrumbs.get(breadcrumbs.size()-1).getPossibleActions());
            Iterator iterator = actions.entrySet().iterator();
            Action nextActionToPerform = null;
            Webpage webpage = null;

            if(actions.size() < 1){
                if(breadcrumbs.size() > 1){
                    performedActions.add(new UserAction(
                            this.id,
                            "Return Action",
                            breadcrumbs.get(breadcrumbs.size()-1).getUrl(),
                            breadcrumbs.get(breadcrumbs.size()-2).getUrl(),
                            LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault())));
                    goBack();
                }
            }

            while(iterator.hasNext()){
                Map.Entry pair = (Map.Entry) iterator.next();
                Action action = (Action) pair.getKey();
                nextActionToPerform = action;
                now = now + action.getTimeActionTakesToPerformInMs();
                if(isActionAlreadyPerformed(action) == false && pair.getValue() != null){
                    webpage = (Webpage) pair.getValue();
                    break;
                }
            }
            if(webpage != null){
                performedActions.add(new UserAction(
                        this.id,
                        nextActionToPerform.getActionId(),
                        breadcrumbs.get(breadcrumbs.size()-1).getUrl(),
                        webpage == null ?  null : webpage.getUrl(),
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault())));
                visitPage(webpage);
                actions.remove(nextActionToPerform);

            }
            else {
                goBack();
            }
        }
        return performedActions;
    }


    /**
     * Private user method, that goes back to previous page
     * called when user has to perform actions, but no more action are available on this webpage
     */
    private void goBack() {
        breadcrumbs.remove(breadcrumbs.get(breadcrumbs.size()-1));
    }

    /**
     * Public method used for testing, should be removed when released
     * @return the actions performed by this user
     */
    public List<UserAction> getPerformedActions() {
        return performedActions;
    }


    @Override
    public String toString(){
        return id;
    }

    /**
     * private method used by the class to check if an action is already performed by this user
     * @param action the action to check if is performed
     * @return boolean, true if the action is already performed, else false
     */
    private boolean isActionAlreadyPerformed(Action action){
        for (UserAction userAction:performedActions) {
            if (userAction.getActionId().equals(action.getActionId())){
                return true;
            }
        }
        return false;
    }

    public String getId() {
        return id;
    }
}
