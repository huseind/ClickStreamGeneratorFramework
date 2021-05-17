package CSGFramework.Generator;

import CSGFramework.User.User;
import CSGFramework.User.UserAction;
import CSGFramework.Website.Webpage;
import CSGFramework.Website.Website;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * class that generates clickstream data.
 */
public class ClickStreamGenerator {
    private Website website;
    private List<User> users;
    // REDUNDANT? user has useractions...
    private List<UserAction> generatedActions;
    private int numberOfLinesToGenerate;
    private List<String> includedDataFields = new ArrayList<>(Arrays.asList("userId", "ationId", "urlOfPageActionWasPerformedOn", "timeActionWasPerformed"));



    ClickStreamGenerator(Website website, List<User> users, int numberOfLinesToGenerate){
        // constructor
        this.website = website;
        this.users = users;
        this.numberOfLinesToGenerate = numberOfLinesToGenerate;
    }

    /**
     * Method that generates a set amout of useractions without the client having to spesify anything
     * @return a list of actions that performed by a set of users.
     */
    public List<UserAction> generateCliksteram(){
        for (User user: users) {
                user.perform(2);
        }
        return generatedActions;
    }



    /**
     *
     * @param website a website object where one wats to see actions required to exhaust all routes
     * @return returns a list of actions performed by user object to exhaust all routes.
     */
    public List<UserAction> exhaust(Website website){
        //TODO: let the user traverse the website, until they have visited all pages
        return generatedActions;
    }

    /**
     *
     * @param website a website where both pages exist
     * @param fromWebpage the page where we want to start
     * @param toWebpage the page where we want to end up
     * @return list of least amount of actions required to go from fromWebpage to toWebpage
     */
    public List<UserAction> generateFastestRoute(Website website, Webpage fromWebpage, Webpage toWebpage){
        //  TODO: impement the method that finds the fastest route from one page to another in a website
        return generatedActions;
    }


    /**
     * Method that clears all generated actions from the generator
     */
    public void resetAllActions(){
        generatedActions.clear();
    }
}
