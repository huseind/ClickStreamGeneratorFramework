package CSGFramework.User;

import CSGFramework.Website.Webpage;

public class UserBuilder {

    private String id = "User " + String.valueOf(System.currentTimeMillis()).substring(5,6);
    private Webpage currentViewingWebpage = null;

    public UserBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder setCurrentViewingWebpage(Webpage currentViewingWebpage) {
        this.currentViewingWebpage = currentViewingWebpage;
        return this;
    }

    public User build(){
        return new User(id, currentViewingWebpage);
    }
}
