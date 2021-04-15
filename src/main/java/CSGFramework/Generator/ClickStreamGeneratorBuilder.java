package CSGFramework.Generator;

import CSGFramework.User.User;
import CSGFramework.User.UserBuilder;
import CSGFramework.Website.Website;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class
 */
public class ClickStreamGeneratorBuilder {
    private Website website;
    private List<User> users = generateUsers();
    private int numberOfLinesToGenerate = 100;
    //TODO: This list should contain values from AvailableOptions enum
    private List<String> includeInGeneratedData= new ArrayList<>(Arrays.asList("userId", "ationId", "urlOfPageActionWasPerformedOn", "timeActionWasPerformed"));


    public ClickStreamGeneratorBuilder setWebsite(Website website) {
        this.website = website;
        return this;
    }

    public ClickStreamGeneratorBuilder addUsers(List<User> users) {
        this.users.addAll(users);
        return this;
    }

    public ClickStreamGeneratorBuilder addUser(User user) {
        this.users.add(user);
        return this;
    }

    public ClickStreamGeneratorBuilder setNumberOfLinesToGenerate(int numberOfLinesToGenerate) {
        this.numberOfLinesToGenerate = numberOfLinesToGenerate;
        return this;
    }


    public ClickStreamGeneratorBuilder includeIpAdress(){
        //TODO: create multiple include...() methods, so the user can choose to include non-defauld columns
        // in the data that is generated
        return this;
    }

    public ClickStreamGeneratorBuilder excludeDate(){
        //TODO: Create multiple exlude...() methods, so the user can choose to exclude columns
        // in the data that is generated
        return this;
    }

    /**
     * Method that genereates a set of default users
     * @return a List of users
     */
    private ArrayList<User> generateUsers(){
        ArrayList<User> returnList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            returnList.add(new UserBuilder().setId("U" + i).build());
        }
        System.out.println(returnList);
        return returnList;
    }

    public ClickStreamGenerator build(){
        return new ClickStreamGenerator(website,users,numberOfLinesToGenerate);
    }
}
