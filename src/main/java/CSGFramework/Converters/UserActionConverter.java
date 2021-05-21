package CSGFramework.Converters;

import CSGFramework.User.UserAction;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to convert user actions to different types
 */
public abstract class UserActionConverter {

    /**
     * converts a list of user actions into a Json object
     * @param actions  a List of User actions
     * @return Json object, all user actions added under userActions field
     */
    public static JsonObject convertUserActionToJson(List<UserAction> actions){
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("userActions",new Gson().toJsonTree(actions));
        return jsonObject;
    }


    /**
     * converts a list of user actions to a csv string
     * @param actions a List of user actions
     * @return a csv string of user actions
     */
    public static String convertUserActionsToCSV(List<UserAction> actions){
        String returnString = "UserId,ActionId,PageActionWasPerformed,RedirectedTo,TimeActionPerformed";
        for (UserAction userAction :actions) {
            String[] actionFields   = userAction.toString().split(" ");
            String actionString = "";
            for (int i = 0; i < actionFields.length; i++) {
                if(i < actionFields.length-1) {
                    actionString += actionFields[i] + ",";
                }
                else {
                    actionString += actionFields[i];
                }
            }
            returnString += "\n" + actionString;
        }
        return returnString;
    }
}
