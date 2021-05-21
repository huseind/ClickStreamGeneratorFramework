package CSGFramework.Website;

import java.util.HashMap;

/**
 * Class that represents a webpage
 */
public class Webpage {
    private Website website;
    private String url;
    private HashMap<Action, Webpage> possibleActions;


    /**
     * default constructor
     * @param url The url for this spesific page
     * @param possibleActions A hashmap of actions and webpages these action redirect to.
     *                        webpage is set to null if it is a non-reduricting action
     *
     */
    Webpage(String url, HashMap<Action, Webpage> possibleActions){
        this.url = url;
        this.possibleActions = possibleActions;
    }

    /**
     * @return int, number of actions on this webpage
     */
    public int getNumberOfActions(){
        return possibleActions.size();
    }

    /**
     * @return HashMap<Action, Webpage>, all possible actions on this webpage
     */
    public HashMap<Action,Webpage> getPossibleActions(){
        return possibleActions;
    }


    public String getUrl(){
        return url;
    }

    @Override
    public String toString(){
        return url;
    }


    /**
     * @param website, Website this page belongs to
     */
    void setWebsite(Website website){
        this.website = website;
    }


    /**
     * Adds a redirecting action to possible actions on this page
     * @param action, the action to be added
     * @param webpage, the webpage action redirects to, null if a non redirecting action
     */
    void addRedirectingAction(Action action, Webpage webpage){
        possibleActions.put(action,webpage);
    }

    /**
     * Adds multiple actions to the webpage
     * @param actions HashMap<Action,Webpage>, the actions to add to possible actions
     */
    void addRedirectingActions(HashMap<Action,Webpage> actions){
        possibleActions.putAll(actions);
    }






}
