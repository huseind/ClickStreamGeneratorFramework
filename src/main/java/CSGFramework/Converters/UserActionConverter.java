package CSGFramework.Converters;

import CSGFramework.User.UserAction;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public abstract class UserActionConverter {

    public static JsonObject convertUserActionToJson(List<UserAction> actions){
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("userActions",new Gson().toJsonTree(actions));
        return jsonObject;
    }

    public static String convertUserActionsToCSV(List<UserAction> actions){
        //TODO: Implemt method to convert userAction to CSV format
        String returnString = "UserId,ActionId,PageActionWasPerformed,RedirectedTo,TimeActionPerformed";
        for (UserAction userAction :actions) {
            String[] actionFields   = userAction.toString().split(" ");
            System.out.println(userAction.toString());
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
