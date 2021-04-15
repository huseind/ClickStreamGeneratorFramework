import CSGFramework.Converters.UserActionConverter;
import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.Generator.ClickStreamGenerator;
import CSGFramework.Generator.ClickStreamGeneratorBuilder;
import CSGFramework.User.UserAction;
import CSGFramework.Website.*;
import CSGFramework.Writers.IWriter;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args){

        // Generate clickstream data without any options specified
        ClickStreamGenerator generator = new ClickStreamGeneratorBuilder().build();
        List<UserAction> data = generator.generateCliksteram();



        //Creating a default website mock with builder
        Website myWebsite = new WebsiteBulder().build();
        System.out.println(myWebsite.toString());


        //Creating a customized page with an action and adding it to a website mock with the builders
        Page homePage = new PageBuilder().setUrl("anotherwebsite.com").addPossibleAction(new ActionBuilder().setActionId("Menu clicked").build()).build();
        Website anotherWebite = new WebsiteBulder().setHomePage(homePage).setName("AnotherWebsite").addPage(homePage).build();


        //Defining fields/ columns to be logged by the framework
        ClickStreamGenerator anotherGenerator = new ClickStreamGeneratorBuilder().includeIpAdress().excludeDate().build();


        // User implementing the they own implementation of the writeToFile() through the IWriter interface
        IWriter myWriter = new IWriter() {
            @Override
            public void writeToFile(String fileURL, List<UserAction> userActions) throws WrongFileTypeException {
                // write to my file
            }
        };

        try {
            myWriter.writeToFile("afile.xml",data);
        }
        catch (WrongFileTypeException e){
            e.getMessage();
        }
    }




}
