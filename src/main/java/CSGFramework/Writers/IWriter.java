package CSGFramework.Writers;

import CSGFramework.Exceptions.WrongFileTypeException;
import CSGFramework.Website.Action;

import java.util.List;

/**
 * interface for classes that write data to file
 */

 interface IWriter {

     void writeToFile (String fileURL, List<Action> actions) throws WrongFileTypeException;
}
