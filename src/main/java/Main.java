import CSGFramework.Converters.Converter;
import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.Generator.ClickStreamGenerator;
import CSGFramework.UserAction;
import CSGFramework.UserActionBuilder;
import CSGFramework.Website.Action;
import CSGFramework.Writers.JSONWriter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args){

        ClickStreamGenerator generator = new ClickStreamGenerator();
        List<UserAction> data = generator.generateCliksteram();

        JSONWriter writer = new JSONWriter();

        try {
            writer.writeToFile("hei",data);
        }
        catch (WrongFileTypeException e){
            e.getMessage();
        }

        UserAction action = new UserActionBuilder().setUser("123").build();
        System.out.println(action);
    }

}
