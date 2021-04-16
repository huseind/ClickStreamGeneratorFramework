package CSGFramework.Website;

import java.util.ArrayList;
import java.util.List;

public class WebsiteBuilder {
    private String name = "mywebsite.com";
    private Page homePage = new PageBuilder().setUrl(name).build();
    private List<Page> allPages = new ArrayList<>(){{add(homePage);}};


    public WebsiteBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WebsiteBuilder setHomePage(Page homePage) {
        this.homePage = homePage;
        return this;
    }

    public WebsiteBuilder addPages(List<Page> allPages) {
        this.allPages.addAll(allPages);
        return this;
    }

    public WebsiteBuilder addPage(Page page) {
        this.allPages.add(page);

        return this;
    }

    public Website build(){
        return new Website(name,homePage,allPages);
    }




}
