import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.Generator.ClickStreamGenerator;
import CSGFramework.Generator.ClickStreamGeneratorBuilder;
import CSGFramework.User.User;
import CSGFramework.User.UserBuilder;
import CSGFramework.Website.Webpage;
import CSGFramework.Website.WebpageBuilder;
import CSGFramework.Website.Website;
import CSGFramework.Website.WebsiteBuilder;
import CSGFramework.Writers.CSVWriter;
import CSGFramework.Writers.JSONWriter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    User user = new UserBuilder().setId("Husein").build();
    ClickStreamGenerator csg = new ClickStreamGeneratorBuilder().setNumberOfLinesToGenerate(2).addUser(user).build();

    @Test
    public void performTest(){
        csg.generateCliksteram();
        assertTrue(!user.getPerformedActions().isEmpty());
        System.out.println(user.getPerformedActions().size());
        assertTrue(user.getPerformedActions().size() == 2);
    }


    User user2 = new UserBuilder().setId("User Husein").build();
    //Webpage webpage = new WebpageBuilder().generateRedirectingActions(1).build();
    Website website = new WebsiteBuilder().build();
    ClickStreamGenerator clickStreamGenerator = new ClickStreamGeneratorBuilder().setWebsite(website).addUser(user2).build();

    @Test
    public void userTest(){

        assertNotNull(user.getId());
        clickStreamGenerator.generateCliksteram();
        try {
            JSONWriter jsonWriter = new JSONWriter();
            jsonWriter.writeToFile("writerTestJson.json",user2.getPerformedActions());
        }catch (WrongFileTypeException e){
            e.printStackTrace();
        }
        try {
            CSVWriter csvWriter = new CSVWriter();
            csvWriter.writeToFile("writerTestCsv.csv",user2.getPerformedActions());
        }catch (WrongFileTypeException e){
            e.printStackTrace();
        }
    }

    @Test
    public void exhaustTest(){
        clickStreamGenerator.exhaust();
    }


}
