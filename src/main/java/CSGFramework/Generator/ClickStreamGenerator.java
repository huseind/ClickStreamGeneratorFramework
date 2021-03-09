package CSGFramework.Generator;

import CSGFramework.User;
import CSGFramework.UserAction;
import CSGFramework.Website.Action;
import CSGFramework.Website.Website;

import java.util.ArrayList;
import java.util.List;

/**
 * class that generates clickstream data.
 */
public class ClickStreamGenerator {
    private Website website;
    private List<User> users;

    // all actions performed by all users
    private List<UserAction> generatedActions;

    /**
     * One of the options, sets how many lines should be generated.
     */
    private int numberOfLinesToGenerate;


    public ClickStreamGenerator(){
        // empty constructor
        // used if the client does not want to spesify a website or a set of users
    }

    public ClickStreamGenerator(Website website, List<User> users, int numberOfLinesToGenerate){
        // constructor
        this.website = website;
        this.users = users;
        this.numberOfLinesToGenerate = numberOfLinesToGenerate;
    }

    /**
     * Method that generates a set amout of useractions without the client having to spesify anything
     * @return a list of actions that performed by a set of users.
     */
    public List<UserAction> generate(){
        List<UserAction> actions = new ArrayList<UserAction>();
        //TODO: generate actions you lazy bastard
        return actions;
    }



    /**
     *
     * @param website a website object where one wats to see actions required to exhaust all routes
     * @return returns a list of actions performed by user object to exhaust all routes.
     */
    public List<UserAction> exhaustAllWebsiteRoutes(Website website){
        // method that takes a makes a user exhaust all routes and returns
        // a list of actions performed by user to exhaus all routes on a given website
        List<UserAction> actions = new ArrayList<UserAction>();
        //TODO: let the user traverse the website, until they have visited all pages
        return actions;
    }

    /**
     * Method that clears all generated actions
     */
    public void resetAllActions(){
        generatedActions.clear();
    }
}
