package CSGFramework.User;

import CSGFramework.Website.Webpage;

/**
 * A builder for the user class
 */
public class UserBuilder {


    private String id = "User" + String.valueOf(System.currentTimeMillis()).substring(5,8);
    private Webpage currentViewingWebpage = null;

    /**
     * Sets the id of the user
     * @param id the id to set
     * @return this instance of the builder
     */
    public UserBuilder setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Set the currentViewingPage of the user
     * @param currentViewingWebpage the webpage to set
     * @return this instance of the builder
     */
    public UserBuilder setCurrentViewingWebpage(Webpage currentViewingWebpage) {
        this.currentViewingWebpage = currentViewingWebpage;
        return this;
    }

    /**
     * creates an instance of the user
     * @return an instance of a user object
     */
    public User build(){
        return new User(id, currentViewingWebpage);
    }
}
