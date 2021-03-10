package CSGFramework.Writers;

import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.UserAction;

import java.util.List;

/**
 * Class that writes data to a set csv file
 */
public class CSVWriter {

    public CSVWriter(){

    }

    public void writeToFile(String fileURL, List<UserAction> userActions) throws WrongFileTypeException {
        // TODO implement write to file JSON
        // will probably throw an exeption if the spesified file is not a json file
        //should not throw an exeption if the file does not exist, just create one.

    }
}
