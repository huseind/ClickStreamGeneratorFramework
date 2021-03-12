package CSGFramework.Website;

import java.util.ArrayList;
import java.util.List;

public class WebsiteBulder {
    private String name = "mywebsite.com";
    private Page homePage; //TODO: Add a default homepage
    private List<Page> allPages = new ArrayList<>();


    public WebsiteBulder setName(String name) {
        this.name = name;
        return this;
    }

    public WebsiteBulder setHomePage(Page homePage) {
        this.homePage = homePage;
        return this;
    }

    public WebsiteBulder addPages(List<Page> allPages) {
        this.allPages.addAll(allPages);
        return this;
    }

    public WebsiteBulder addPage(List<Page> allPages) {
        this.allPages.addAll(allPages);
        return this;
    }

    public Website build(){
        return new Website(name,homePage,allPages);
    }




}
