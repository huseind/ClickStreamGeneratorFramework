package CSGFramework.Writers;

import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.User.UserAction;

import java.util.List;

/**
 * interface for classes that write data to file
 */

 public interface IWriter {

     void writeToFile (String fileURL, List<UserAction> userActions) throws WrongFileTypeException;
}
