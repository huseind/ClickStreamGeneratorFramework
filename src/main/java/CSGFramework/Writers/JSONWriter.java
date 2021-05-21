package CSGFramework.Writers;

import CSGFramework.Converters.UserActionConverter;
import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.User.User;
import CSGFramework.User.UserAction;
import com.google.gson.JsonObject;

import java.io.*;

import java.util.List;

/**
 * Class that writes data to a provided JSON file
 */
public class JSONWriter implements IWriter{


    /**
     *
     * @param filename the name of file to write to
     * @param userActions list of UserActions to write
     * @throws WrongFileTypeException if filename does not refer to a json file
     */
    @Override
    public void writeToFile(String filename, List<UserAction> userActions) throws WrongFileTypeException {
        String extention = filename.split("\\.")[1];
        if (!extention.equalsIgnoreCase("json")){
            throw new WrongFileTypeException();
        }
        BufferedWriter output = null;
        try {
            File file = new File(filename);
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
