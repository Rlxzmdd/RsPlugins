package Rs.Plugin.Money;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;

import java.io.File;

/**
 * Created by Rlx on 2016/2/15.
 */
public class MoneyConfig {
    public File pluginfile = new File("plugins/RsMoney/").getAbsoluteFile();
    public File file = new File("plugins/RsMoney/Players/").getAbsoluteFile();
    public String name;
    public Config config = null;
    public MoneyConfig(String name){
        this.name = name;
    }
    public MoneyConfig(Player player){
        name = player.getName();
    }
    public Config getConfig(){
        //this.newConfig();
        if(config == null){
            config = new Config(file+"/"+this.name+".json",Config.JSON);
            return config;
        }
        return config;
    }
    public void newConfig(){
        File playerfile = new File(file+"/"+this.name+".json");
        if(playerfile.exists()){
            return;
        }else{
            this.getConfig().set("Money",(float)(new Config(this.pluginfile+"/config.yml")).getDouble("Money"));
            this.getConfig().set("Point",(float)(new Config(this.pluginfile + "/config.yml")).getDouble("Point"));
            this.getConfig().save();
        }
    }
    public void setPoint(float point){
        this.getConfig().set("Point",point);
        this.getConfig().save();
    }
    public float getPoint(){
        return (float)(new Config(this.pluginfile+"config.yml")).getDouble("Point");
    }
    public void setMoney(float point){
        this.getConfig().set("Money",point);
        this.getConfig().save();
    }
    public float getMoney(){
        return (float)(new Config(this.pluginfile+"config.yml")).getDouble("Money");
    }
}
