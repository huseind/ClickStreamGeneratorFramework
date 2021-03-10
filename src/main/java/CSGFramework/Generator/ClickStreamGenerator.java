package CSGFramework.Generator;

import CSGFramework.User;
import CSGFramework.UserAction;
import CSGFramework.Website.Action;
import CSGFramework.Website.Page;
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
    private List<String> includeInGeneratedData = List.of("userId","ationId","urlOfPageActionWasPerformedOn","timeActionWasPerformed");

    private enum availableOptions{
        userId,
        actionId,
        urlOfPageActionWasPerformedOn,
        timeActionWasPerformed
    }

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
    public List<UserAction> generateCliksteram(){
        //TODO: generate actions you lazy bastard
        return generatedActions;
    }



    /**
     *
     * @param website a website object where one wats to see actions required to exhaust all routes
     * @return returns a list of actions performed by user object to exhaust all routes.
     */
    public List<UserAction> exhaus(Website website){
        // method that takes a makes a user exhaust all routes and returns
        // a list of actions performed by user to exhaus all routes on a given website
        //TODO: let the user traverse the website, until they have visited all pages
        return generatedActions;
    }

    /**
     *
     * @param website a website where both pages exist
     * @param fromPage the page where we want to start
     * @param toPage the page where we want to end up
     * @return list of least amount of actions required to go from fromPage to toPage
     */
    public List<UserAction> generateFastestRoute(Website website, Page fromPage, Page toPage){
        //  TODO: impement the method that finds the fastest route from one page to another in a website
        return generatedActions;
    }

    /**
     *
     * @param fieldToExclude takes a string what
     */
    public void exclude(String fieldToExclude){
        if (includeInGeneratedData.contains(fieldToExclude)){
            includeInGeneratedData.remove(fieldToExclude);
        }
    }

    /**
     * Method that clears all generated actions from the generator
     */
    public void resetAllActions(){
        generatedActions.clear();
    }
}
