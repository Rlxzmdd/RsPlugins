package Rs.Plugin.World.Utils;

import Rs.Plugin.World.Object.Trust;
import Rs.Plugin.World.WorldMainClass;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/3/21.
 */
public class WorldTrust {
    public WorldMainClass main;
    public WorldTrust(WorldMainClass main){
        this.main = main;
    }
    public void addTrust(String world,String name){
        if (main.AllWorld.get(world).containsKey(name)){
            return;
        }
            Map<String, Boolean> asd = new HashMap<String, Boolean>();
            asd.put("Place", true);
            asd.put("Break", true);
            asd.put("Chest", true);
        asd.put("Move", true);
        asd.put("Sign", true);
            asd.put("Use", true);
            asd.put("Pvp", true);
            asd.put("Tp", true);
            main.AllWorld.get(world).put(name,asd);
    }
    public void removeTrust(String world,String name){
            if (!main.AllWorld.get(world).containsKey(name)){
                return;
            }
            main.AllWorld.get(world).remove(name);
    }
    public Trust getTrust(String world){
        return new Trust(main.getAllWorld().get(world));
    }
}
