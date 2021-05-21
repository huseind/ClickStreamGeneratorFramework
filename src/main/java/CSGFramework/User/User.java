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


    public void setCurrentViewingWebpage(Webpage currentViewingWebpage) {
        vistitedWebpages.add(currentViewingWebpage);
        breadcrumbs.add(currentViewingWebpage);
    }


    // new before final
    /**
     * Method for a user to perform a set number of actions.
     * Starts at home page and does and action, if the action is redirecting, currentViewingPage changes
     * Will not perform numberOfActionsToPerform if the website does not contain enough actions!
     * @param numberOfActionsToPerform
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
            /*
            if(actions.size() < 1 && i != 0){
                goBack();
                if(previousWebpage != null &&!(currentViewingWebpage.getUrl().equals(previousWebpage.getUrl()))) {
                    performedActions.add(new UserAction(this.id, "Return Action", currentViewingWebpage.getUrl(),previousWebpage.getUrl(), LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault())));
                }
                i--;
            }
            */

            // iterating though actions to find the one with biggest chance of being performed
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
                            System.out.println(webpage);
                        }
                    }
                }

            // if we have not performed that action, perform it
            if (nextActionToPerform != null) {
                //performedActions.add(new UserAction(this.id, nextActionToPerform.getActionId(), currentViewingWebpage.getUrl(),webpage == null ?  null : webpage.getUrl(), LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault())));

                performedActions.add(new UserAction(this.id, nextActionToPerform.getActionId(), breadcrumbs.get(breadcrumbs.size()-1).getUrl(),webpage == null ?  null : webpage.getUrl(), LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault())));
                actions.remove(nextActionToPerform);
                // redirect if its a redirecting action
                if (webpage != null) {
                    visitPage(webpage);
                    /*
                    previousWebpage = currentViewingWebpage;
                    currentViewingWebpage = webpage;
                    // if not already visited, add page to visited
                    if(!vistitedWebpages.contains(currentViewingWebpage)) {
                        vistitedWebpages.add(currentViewingWebpage);
                    }
                    breadcrumbs.add(currentViewingWebpage);
                    */

                }
            }
        }
        for (UserAction userAction:performedActions) {
            System.out.println(userAction);
        }
        System.out.println(vistitedWebpages);
        return performedActions;
    }

    private void visitPage(Webpage webpage) {
        breadcrumbs.add(webpage);
        if(!vistitedWebpages.contains(webpage)) {
            vistitedWebpages.add(webpage);
        }
    }


    // autogenerated redirecting actions, create pages that are not on the website
    // therefore, there is no way of knowing if we have visited all pages.
    public List<UserAction> exhaustAllRoutes(Website website){
        //currentViewingWebpage = website.getHomeWebpage();
        List<Webpage> allPages = website.getAllWebpages();
        long now = System.currentTimeMillis();
        System.out.println("ALL PAGES: " +allPages);
        while(vistitedWebpages.size() < allPages.size()){
            HashMap<Action,Webpage> actions = new HashMap<>(breadcrumbs.get(breadcrumbs.size()-1).getPossibleActions());
            Iterator iterator = actions.entrySet().iterator();
            Action nextActionToPerform = null;
            Webpage webpage = null;

            if(actions.size() < 1){
                if(breadcrumbs.size() > 1){
                    performedActions.add(new UserAction(this.id, "Return Action", breadcrumbs.get(breadcrumbs.size()-1).getUrl(),breadcrumbs.get(breadcrumbs.size()-2).getUrl(), LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault())));
                    goBack();
                }
            }

            while(iterator.hasNext()){
                Map.Entry pair = (Map.Entry) iterator.next();
                Action action = (Action) pair.getKey();
                nextActionToPerform = action;
                now = now + action.getTimeActionTakesToPerformInMs();
                if(isActionAlreadyPerformed(action) == false && pair.getValue() != null){
                    System.out.println("Fond an action");
                    webpage = (Webpage) pair.getValue();
                    break;
                }
            }
            if(webpage != null){
                performedActions.add(new UserAction(this.id, nextActionToPerform.getActionId(), breadcrumbs.get(breadcrumbs.size()-1).getUrl(),webpage == null ?  null : webpage.getUrl(), LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault())));
                visitPage(webpage);
                actions.remove(nextActionToPerform);

            }
            else {
                goBack();
            }
        }
        System.out.println("ALL ACTIONS: " +performedActions);
        System.out.println(vistitedWebpages);
        return performedActions;
    }


    /**
     * Private user method, that goes back to previous page
     * called when user has to perform actions, but no more action are available on this webpage
     */
    private void goBack() {
        breadcrumbs.remove(breadcrumbs.get(breadcrumbs.size()-1));

        /*
            for(int i = 0; i < vistitedWebpages.size(); i++){
                if(vistitedWebpages.get(i) == currentViewingWebpage){
                    if(i > 0) {
                        currentViewingWebpage = vistitedWebpages.get(i - 1);
                        if(i > 1) {
                            previousWebpage = vistitedWebpages.get(i - 2);
                        }
                        else {
                            previousWebpage = null;
                        }
                    }

                }
            }
            */
            //if(!(currentViewingWebpage == null && previousWebpage == null)) {
                //currentViewingWebpage = previousWebpage;
            // }


    }

    // TODO: REMOVE THIS!!! WHEN DONE
    public List<UserAction> getPerformedActions() {
        return performedActions;
    }

    @Override
    public String toString(){
        return id;
    }

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
