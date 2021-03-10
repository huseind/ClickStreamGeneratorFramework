package CSGFramework.Writers;

import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.UserAction;
import CSGFramework.Website.Action;

import java.util.List;

/**
 * interface for classes that write data to file
 */

 interface IWriter {

     void writeToFile (String fileURL, List<UserAction> userActions) throws WrongFileTypeException;
}
