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

    public int getNumberOfActions(){
        return possibleActions.size();
    }


    public String getUrl(){
        return url;
    }

    @Override
    public String toString(){
        return url;
    }
}
