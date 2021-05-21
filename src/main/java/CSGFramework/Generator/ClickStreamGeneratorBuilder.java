package CSGFramework.Generator;

import CSGFramework.User.User;
import CSGFramework.User.UserBuilder;
import CSGFramework.Website.Website;
import CSGFramework.Website.WebsiteBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Builder class for clickStreamGenerator
 */
public class ClickStreamGeneratorBuilder {
    private Website website = new WebsiteBuilder().build();
    private int numberOfAutoGeneratedUsers = 1;
    private List<User> users = new ArrayList<>();
    private int numberOfActionsToGenerate = 10;
    //TODO: This list should contain values from AvailableOptions enum
    private List<AvailableOptions> includedDataFields = new ArrayList<>(Arrays.asList(AvailableOptions.class.getEnumConstants()));//new ArrayList<>(Arrays.asList("userId", "ationId", "urlOfPageActionWasPerformedOn", "timeActionWasPerformed"));


    /**
     * Builds clickStreamGenerator object
     * will first check if any users exist, if not generate 10 or an specified amount, before returning a generator.
     * each user is then set to start at the homepage
     * @return Object of the generator
     */
    public ClickStreamGenerator build(){
        if (users.isEmpty()){
            generateUsers(numberOfAutoGeneratedUsers);
        }
        else{ // added before final
            for (User user: users) {
                user.setCurrentViewingWebpage(website.getHomeWebpage());
            }
        }
        return new ClickStreamGenerator(website,users, numberOfActionsToGenerate);
    }


    /**
     * Sets the website clickstream data is generated on
     * @param website website to generate clickstream data on
     * @return this instance of the builder
     */
    public ClickStreamGeneratorBuilder setWebsite(Website website) {
        this.website = website;
        return this;
    }

    /**
     * Sets the number of autogenerated users
     * @param numberOfAutoGeneratedUsers int, number of users that should be generated
     * @return this instance of the builder
     */
    public ClickStreamGeneratorBuilder setNumberOfAutoGeneratedUsers(int numberOfAutoGeneratedUsers){
        this.numberOfAutoGeneratedUsers = numberOfAutoGeneratedUsers;
        return this;
    }

    /**
     * add multiple predefined users that will be used to generate clickstream data
     * @param users List of users to add
     * @return this instance of the builder
     */
    public ClickStreamGeneratorBuilder addUsers(List<User> users) {
        this.users.addAll(users);
        return this;
    }

    /**
     * add one predefined users that will be used to generate clickstream data
     * @param user the user to add
     * @return this instance of the builder
     */
    public ClickStreamGeneratorBuilder addUser(User user) {
        this.users.add(user);
        return this;
    }

    /**
     * set the number of actions to generate
     * @param numberOfActionsToGenerate int, number of actions that should be generated
     * @return this instance of the builder
     */
    public ClickStreamGeneratorBuilder setNumberOfActionsToGenerate(int numberOfActionsToGenerate) {
        this.numberOfActionsToGenerate = numberOfActionsToGenerate;
        return this;
    }

    /**
     * excludes ipadress in the generated user actions
     * @return this instance of the builder
     */
    public ClickStreamGeneratorBuilder excludeIpAdress(){
        //TODO: create multiple include...() methods, so the user can choose to include non-defauld columns
        // in the data that is generated
        return this;
    }

    /**
     * exludes the date/time the action was performed
     * @return this instance of the builder
     */
    public ClickStreamGeneratorBuilder excludeDate(){
        //TODO: Create multiple exlude...() methods, so the user can choose to exclude columns
        // in the data that is generated
        includedDataFields.remove(AvailableOptions.timeActionWasPerformed);
        return this;
    }


    /////////////////////////////////////// PRIVATE: ONLY USED BY FRAMEWORK /////////////////////////////////////////////////

    /**
     * Method that genereates a set of default users and sets the current viewing page to homePage
     * @return this instance of the builder
     */
    private ClickStreamGeneratorBuilder generateUsers(int numberOfAutoGeneratedUsers){
        ArrayList<User> returnList = new ArrayList<>();
        for (int i = 1; i <= numberOfAutoGeneratedUsers; i++){
            returnList.add(new UserBuilder().setId("User" + i).setCurrentViewingWebpage(website.getHomeWebpage()).build());
        }
        users.addAll(returnList);
        return this;
    }
}
