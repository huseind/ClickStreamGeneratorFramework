import CSGFramework.Converters.Converter;
import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.Generator.ClickStreamGenerator;
import CSGFramework.Website.Action;
import CSGFramework.Writers.JSONWriter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args){

        ClickStreamGenerator generator = new ClickStreamGenerator();
        List<Action> data = generator.generate();

        JSONWriter writer = new JSONWriter();

        try {
            writer.writeToFile("hei",data);
        }
        catch (WrongFileTypeException e){
            e.getMessage();
        }



    }

}
