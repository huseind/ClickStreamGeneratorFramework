package CSGFramework.Website;

import java.util.ArrayList;
import java.util.List;

public class PageBuilder {
    private String url;
    private List<Page> linkedPages = new ArrayList<>();
    private List<Action> possibleActions = new ArrayList<>();


    public PageBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     *
     * @param linkedPages a list of pages
     * @return PageBuilder object
     */
    public PageBuilder addLinkedPages(List<Page> linkedPages) {
        this.linkedPages.addAll(linkedPages);
        return this;
    }

    /**
     *
     * @param linkedPage a page object
     * @return PageBuilder object
     */
    public PageBuilder addLinkedPage(Page linkedPage) {
        linkedPages.add(linkedPage);
        return this;
    }



    public PageBuilder addPossibleActions(List<Action> possibleActions) {
        this.possibleActions.addAll(possibleActions);
        return this;
    }

    public PageBuilder addPossibleAction(Action possibleAction) {
        this.possibleActions.add(possibleAction);
        return this;
    }



    public Page build(){
        return new Page(url,linkedPages,possibleActions);
    }
}
