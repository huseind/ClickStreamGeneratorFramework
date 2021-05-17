package CSGFramework.Website;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a website
 */
public class Website {
    private String name;
    private Webpage homeWebpage;
    private List<Webpage> allWebpages;

    Website(String name, Webpage homeWebpage, List<Webpage> allWebpages) {
        this.name = name;
        this.homeWebpage = homeWebpage;
        this.allWebpages = allWebpages;
    }

    public Webpage getHomeWebpage() {
        return homeWebpage;
    }

    public List<Webpage> getAllWebpages() {
        return allWebpages;
    }


    @Override
    public String toString(){
        return "Name: " + name + "\n" + "HomePage " + homeWebpage.getUrl() + "\n" + "All pages" + allWebpages;
    }

    // new Before final
    public void addWebpage(Webpage page){
        allWebpages.add(page);
    }

    public void addWebpages(ArrayList<Webpage> pages){
        allWebpages.addAll(pages);
    }

}
