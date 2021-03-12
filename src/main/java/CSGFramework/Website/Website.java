package CSGFramework.Website;

import java.util.List;

/**
 * A class that represents a website
 */
public class Website {
    private String name;
    private Page homePage;
    private List<Page> allPages;

    Website(String name, Page homePage, List<Page> allPages) {
        this.name = name;
        this.homePage = homePage;
        this.allPages = allPages;
    }

}
