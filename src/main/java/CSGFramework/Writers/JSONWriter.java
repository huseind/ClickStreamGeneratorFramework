package CSGFramework.Writers;

import CSGFramework.Converters.UserActionConverter;
import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.User.User;
import CSGFramework.User.UserAction;
import com.google.gson.JsonObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that writes data to a provided JSON file
 */
public class JSONWriter implements IWriter{


    @Override
    public void writeToFile(String fileURL, List<UserAction> userActions) throws WrongFileTypeException {
        String extention = fileURL.split("\\.")[1];
        if (!extention.equalsIgnoreCase("json")){
            throw new WrongFileTypeException();
        }
        BufferedWriter output = null;
        try {
            File file = new File(fileURL);
            output = new BufferedWriter(new FileWriter(file));
            JsonObject jsonObject = UserActionConverter.convertUserActionToJson(userActions);

                output.write(jsonObject.toString());


        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                try {
                    output.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
