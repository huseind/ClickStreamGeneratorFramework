import CSGFramework.Converters.UserActionConverter;
import CSGFramework.Generator.ClickStreamGenerator;
import CSGFramework.Generator.ClickStreamGeneratorBuilder;
import CSGFramework.User.UserAction;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args){
       /*
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ClickStreamGenerator generator = new ClickStreamGenerator();
        List<UserAction> data = generator.generateCliksteram();
        String dataInJson = UserActionConverter.convertUserActionToJson(data);


        JSONWriter writer = new JSONWriter();

        try {
            writer.writeToFile("hei.json",data);
        }
        catch (WrongFileTypeException e){
            e.getMessage();
        }

        UserAction action = new UserActionBuilder().setUser("123").build();
        System.out.println(action);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Page articlePage = new Page("mysite.com/article",null, null);

        Action navigateToArticle = new Action("Acticle link clicked", 2,true,articlePage);
        List<Action> actionList = new ArrayList<>();
        actionList.add(navigateToArticle);

        List<Page> linkedToHomePage = new ArrayList<>();
        linkedToHomePage.add(articlePage);
        Page homePage = new Page("mysite.com",linkedToHomePage,actionList);

        List<Page> allWebsitePages = new ArrayList<>();
        allWebsitePages.add(homePage);
        allWebsitePages.add(articlePage);

        Website myWebsite = new Website("MyWebsite",homePage,allWebsitePages);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        Action oneAction = new Action("User logged in",2,false,null);
        Page myPage = new Page();
        myPage.addAction(oneAction);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ClickStreamGenerator generator1 = new ClickStreamGenerator();
        List<UserAction> actionsToExhaustAllRoutes = generator1.exhaust(myWebsite);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ClickStreamGenerator anotherGenerator = new ClickStreamGenerator();
        generator.generateFastestRoute(myWebsite,homePage,articlePage);
        */

        ClickStreamGenerator generator = new ClickStreamGeneratorBuilder().build();
        List<UserAction> data = generator.generateCliksteram();
        String dataInJson = UserActionConverter.convertUserActionToJson(data);

        //TODO: do the scenarios over again with builders!
    }




}
