package CSGFramework.Writers;

import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.User.UserAction;

import java.util.List;

/**
 * interface for classes that write data to file
 */

 public interface IWriter {
    /**
     * Method to be overwritten when implementing a writer
     * @param filename, name of the file to be writeen to
     * @param userActions List of user action that need to written to file
     * @throws WrongFileTypeException exception thrown when user tries to write to the wrong file format
     */
     void writeToFile (String filename, List<UserAction> userActions) throws WrongFileTypeException;
}
