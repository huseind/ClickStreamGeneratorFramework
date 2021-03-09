package CSGFramework.Website;

import java.util.List;

public class Page {
    private String url;
    //This a list of edges/ pages, if we look at the weighted graph mentioned earlier
    private List<Page> linkedPages;
    private List<Action> possibleActions;

    public Page() {
        //empty constructor
    }

    public Page(List<Page> linkedPages, List<Action> possibleActions){
        this.linkedPages = linkedPages;
        this.possibleActions = possibleActions;
    }

    public List<Page> getLinkedPages() {
        return linkedPages;
    }
}
