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
    private List<UserAction> generatedActions = new ArrayList<>();
    private int numberOfLinesToGenerate;
    private List<String> includedDataFields = new ArrayList<>(Arrays.asList("userId", "ationId", "urlOfPageActionWasPerformedOn", "timeActionWasPerformed"));


    /**
     * package private constructor
     * @param website Website to generate clickstream data on
     * @param users the users that are going to perform actions
     * @param numberOfLinesToGenerate the number of actions each user is going to generate
     */
    ClickStreamGenerator(Website website, List<User> users, int numberOfLinesToGenerate){
        this.website = website;
        this.users = users;
        this.numberOfLinesToGenerate = numberOfLinesToGenerate;
    }

    /**
     * generates a set amount of useractions without the client having to specify anything
     * @return a list of actions that performed by a set of users.
     */
    public List<UserAction> generateCliksteram(){
        for (User user: users) {
            generatedActions.addAll(user.perform(numberOfLinesToGenerate));

        }
        return generatedActions;
    }



    /**
     * exhaust every route on the website, in other words performs every redirecting action
     * @return returns a list of actions performed by user object to exhaust all routes.
     */
    public List<UserAction> exhaust(){
        for (User user:users) {
            user.exhaustAllRoutes(website);
        }
        return generatedActions;
    }

    /**
     * generates the fastest route from fromWebpage to toWebpage,
     * fastest route is the least amount of actions required
     * @param fromWebpage the page where we want to start
     * @param toWebpage the page where we want to end up
     * @return list of least amount of actions required to go from fromWebpage to toWebpage
     */
    public List<UserAction> generateFastestRoute( Webpage fromWebpage, Webpage toWebpage){
        //  TODO: impement the method that finds the fastest route from one page to another in a website
        return generatedActions;
    }


    /**
     * clears all generated actions from the generator
     */
    public void resetAllActions(){
        generatedActions.clear();
    }
}
