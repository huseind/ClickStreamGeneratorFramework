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

    /**
     * writes csv data to file
     * @param filename the file data should be written to
     * @param userActions, List of UserActions to be written to file
     * @throws WrongFileTypeException exception thrown when the file extension does not mach .csv
     */
    public void writeToFile(String filename, List<UserAction> userActions) throws WrongFileTypeException {
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
