package CSGFramework.Converters;

import CSGFramework.User.UserAction;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public abstract class UserActionConverter {

    public static JsonObject convertUserActionToJson(List<UserAction> actions){
        /*
        ArrayList<String> userActionsJson = new ArrayList<>();
        Gson gson = new Gson();
        for (UserAction action:actions) {
            String stringAction = gson.toJson(action);
            userActionsJson.add(stringAction);
        }
        return userActionsJson;
        */
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("userActions",new Gson().toJsonTree(actions));
        return jsonObject;
    }

    public static String convertUserActionsToCSV(List<UserAction> action){
        //TODO: Implemt method to convert userAction to CSV format
        return "";
    }
}
