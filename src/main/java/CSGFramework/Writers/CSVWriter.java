package CSGFramework.Writers;

import CSGFramework.Converters.UserActionConverter;
import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.User.UserAction;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Class that writes data to a set csv file
 */
public class CSVWriter {

    public CSVWriter(){

    }

    public void writeToFile(String filename, List<UserAction> userActions) throws WrongFileTypeException {
        // TODO implement write to file JSON
        // will probably throw an exeption if the spesified file is not a json file
        //should not throw an exeption if the file does not exist, just create one.
        String extention = filename.split("\\.")[1];
        if (!extention.equalsIgnoreCase("csv")){
            throw new WrongFileTypeException();
        }
        BufferedWriter output = null;
        try {
            File file = new File(filename);
            output = new BufferedWriter(new FileWriter(file));
            output.write(UserActionConverter.convertUserActionsToCSV(userActions));

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
