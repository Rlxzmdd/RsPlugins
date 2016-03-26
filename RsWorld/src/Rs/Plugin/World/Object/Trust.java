package Rs.Plugin.World.Object;

import Rs.Plugin.World.WorldMainClass;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/3/21.
 */
public class Trust {
    public Map<String,Map<String,Boolean>> trusts;
    public Trust(Map<String,Map<String,Boolean>> trusts){
        this.trusts = trusts;
    }
    public Boolean canBreak(String PlayerName){
        if(trusts == null){
            return true;
        }
        if(trusts.containsKey(PlayerName)){
            return trusts.get(PlayerName).get("Break");
        }
        return trusts.get("Permission").get("Break");
    }
    public Boolean canPlace(String PlayerName){
        if(trusts == null){
            return true;
        }
        if(trusts.containsKey(PlayerName)){
            return trusts.get(PlayerName).get("Place");
        }
        return trusts.get("Permission").get("Place");
    }
    public Boolean canMove(String PlayerName){
        if(trusts == null){
            return true;
        }
        if(trusts.containsKey(PlayerName)){
            return trusts.get(PlayerName).get("Move");
        }
        return trusts.get("Permission").get("Move");
    }
    public Boolean canChest(String PlayerName){
        if(trusts == null){
            return true;
        }
        if(trusts.containsKey(PlayerName)){
            return trusts.get(PlayerName).get("Chest");
        }
        return trusts.get("Permission").get("Chest");
    }
    public Boolean canTp(String PlayerName){
        if(trusts == null){
            return true;
        }
        if(trusts.containsKey(PlayerName)){
            return trusts.get(PlayerName).get("Tp");
        }
        return trusts.get("Permission").get("Tp");
    }
    public Boolean canUse(String PlayerName){
        if(trusts == null){
            return true;
        }
        if(trusts.containsKey(PlayerName)){
            return trusts.get(PlayerName).get("Use");
        }
        return trusts.get("Permission").get("Use");
    }
    public Boolean canSign(String PlayerName){
        if(trusts == null){
            return true;
        }
        if(trusts.containsKey(PlayerName)){
            return trusts.get(PlayerName).get("Sign");
        }
        return trusts.get("Permission").get("Sign");
    }
}
