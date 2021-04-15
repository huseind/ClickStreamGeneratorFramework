package CSGFramework.Website;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private String url;
    private List<Page> linkedPages = new ArrayList<>();
    private List<Action> possibleActions = new ArrayList<>();


    Page(String url,List<Page> linkedPages, List<Action> possibleActions){
        this.url = url;
        this.linkedPages = linkedPages;
        this.possibleActions = possibleActions;
    }


    public List<Page> getLinkedPages() {
        return linkedPages;
    }

    public String getUrl(){
        return url;
    }

    @Override
    public String toString(){
        return url;
    }
}
