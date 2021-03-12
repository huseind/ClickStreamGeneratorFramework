package CSGFramework.User;

import CSGFramework.Website.Page;

public class UserBuilder {

    private String id;
    private Page currentViewingPage = null;

    public UserBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder setCurrentViewingPage(Page currentViewingPage) {
        this.currentViewingPage = currentViewingPage;
        return this;
    }

    public User build(){
        return new User(id,currentViewingPage);
    }
}
