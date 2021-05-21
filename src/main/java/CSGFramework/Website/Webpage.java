package CSGFramework.Website;

import java.util.HashMap;

/**
 * Class that represents a webpage
 */
public class Webpage {
    private Website website; // TODO: remove this? site should know what pages it has but why the other way around?
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

    public int getNumberOfActions(){
        return possibleActions.size();
    }

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


    // new before final
    void setWebsite(Website website){
        this.website = website;
    }

    void addRedirectingAction(Action action, Webpage webpage){
        possibleActions.put(action,webpage);
    }

    void addRedirectingActions(HashMap<Action,Webpage> actions){
        possibleActions.putAll(actions);
    }






}
