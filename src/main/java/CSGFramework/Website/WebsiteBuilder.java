package CSGFramework.Website;

import java.util.ArrayList;
import java.util.List;

public class WebsiteBuilder {
    private String name = "mywebsite.com";
    private Webpage homeWebpage = new WebpageBuilder().setUrl(name).build();
    private List<Webpage> allWebpages = new ArrayList<>(){{add(homeWebpage);}};


    public WebsiteBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WebsiteBuilder setHomeWebpage(Webpage homeWebpage) {
        this.homeWebpage = homeWebpage;
        return this;
    }

    public WebsiteBuilder addPages(List<Webpage> allWebpages) {
        this.allWebpages.addAll(allWebpages);
        return this;
    }

    public WebsiteBuilder addPage(Webpage webpage) {
        this.allWebpages.add(webpage);

        return this;
    }

    public Website build(){
        return new Website(name, homeWebpage, allWebpages);
    }




}
