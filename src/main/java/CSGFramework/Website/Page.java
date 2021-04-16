package CSGFramework.Website;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Page {
    private Website website;
    private String url;
    private HashMap<Action,Page> possibleActions;


    Page(String url, HashMap<Action,Page> possibleActions){
        this.url = url;
        this.possibleActions = possibleActions;
    }



    public String getUrl(){
        return url;
    }

    @Override
    public String toString(){
        return url;
    }
}
