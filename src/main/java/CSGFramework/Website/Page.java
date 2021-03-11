package CSGFramework.Website;

import java.util.List;

public class Page {
    private String url;
    private List<Page> linkedPages;
    private List<Action> possibleActions;

    public Page() {
        //empty constructor
    }

    public Page(String url,List<Page> linkedPages, List<Action> possibleActions){
        this.url = url;
        this.linkedPages = linkedPages;
        this.possibleActions = possibleActions;
    }

    public void addAction(Action action){
        possibleActions.add(action);
    }

    public List<Page> getLinkedPages() {
        return linkedPages;
    }

    public String getUrl(){
        return url;
    }
}
