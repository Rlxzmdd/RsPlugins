package Rs.Plugin.World.Utils;

import Rs.Plugin.World.Object.World;
import Rs.Plugin.World.WorldMainClass;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2016/3/21.
 */
public class WorldUtils {
    public String name;
    public WorldMainClass main;
    public WorldUtils(WorldMainClass main,String name){
        this.name = name;
        this.main = main;
    }
    public void createWorld(){
        if(main.getAllWorld().containsKey(name)){
            return;
        }
        Map<String, Boolean> asd = new HashMap<String, Boolean>();
        asd.put("Place", false);
        asd.put("Break", false);
        asd.put("Chest", false);
        asd.put("Move", true);
        asd.put("Sign", true);
        asd.put("Use", true);
        asd.put("Pvp", false);
        asd.put("Tp", true);
        //Map<String, Boolean> Permission = new HashMap<String, Boolean>();
       //asd.put("place", false);
       // asd.put("break", false);
      ///  asd.put("chest", false);
      //  asd.put("move", true);
      //  asd.put("use", false);
      //  asd.put("pvp", false);
     //   asd.put("tp", true);
        Map<String,Map<String,Boolean>> qwe = new HashMap<String,Map<String, Boolean>>();
        qwe.put("Permission",asd);
        //qwe.put("zmdd",asd);
        // plugin.AllWorld.put("asd",qwe);
        main.AllWorld.put(name,qwe);
    }
    public void del(){
        if(!main.getAllWorld().containsKey(name)){
            return;
        }
        Map asd = main.getAllWorld().remove(name);
        main.setAllWorld((LinkedHashMap<String, Map<String, Map<String, Boolean>>>) asd);
    }
    public World getObject(){
        return new World(main,name);
    }
}
