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

    /**
     * package private constuctor
     * @param name String, name of the website
     * @param homeWebpage, Webpage, the homepage
     * @param allWebpages, List of all pages on this website
     */
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

    /**
     * adds a webpage to the list of all pages
     * @param webpage, the webpage to be added
     */
    public void addWebpage(Webpage webpage){
        allWebpages.add(webpage);
    }

    /**
     * adds multiple webpages to the list of all webpages
     * @param webpages, List of webpages tobe added
     */
    public void addWebpages(List<Webpage> webpages){
        allWebpages.addAll(webpages);
    }



}
