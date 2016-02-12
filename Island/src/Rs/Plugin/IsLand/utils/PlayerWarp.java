package Rs.Plugin.IsLand.utils;

import cn.nukkit.Player;
import cn.nukkit.math.Vector3;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.Map;

/**
 * Created by Rlx on 2016/2/7.
 */
public class PlayerWarp {
    String name;
    Config config = null;
    public PlayerWarp(String name){
        this.name = name;
    }
    public PlayerWarp(Player player){
        this.name = player.getName();
    }
    public String getFile(){
        return (new File("plugins/IsLand/").getAbsolutePath());
    }
    public Config getConfig(){
        Config config = new Config(new File(getFile()+"/PlayerWarp.json"),Config.JSON);
        if(this.config == null){
            this.config = config;
            return config;
        }else{
            return this.config;
        }
    }
    public void setWarp(Vector3 asd){
        long x = ((Double)asd.getX()).longValue();
        long y = ((Double)asd.getY()).longValue();
        long z = ((Double)asd.getZ()).longValue();
        Map<String,String> asdasd = (Map<String,String>)this.getConfig().get("Warp");
        asdasd.put(name,x+"."+y+"."+z);
        this.getConfig().set("Warp",asdasd);
        this.getConfig().save();
    }
    public Vector3 getWarp(){
        if(!((Map<String,String>)this.getConfig().get("Warp")).containsKey(name)){
            return null;
        }
        System.out.println(this.getConfig().get("Warp"));
        String[] strs = (((Map<String,String>)this.getConfig().get("Warp")).get(name)).split("\\.");
        long x = Long.parseLong(strs[0]);
        long y = Long.parseLong(strs[1]);
        long z = Long.parseLong(strs[2]);

        return (new Vector3(x,y,z));
    }
}

