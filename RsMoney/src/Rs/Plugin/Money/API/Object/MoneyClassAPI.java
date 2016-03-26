package Rs.Plugin.Money.API.Object;

import Rs.Plugin.Money.MoneyMainClass;
import cn.nukkit.Player;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/3/24.
 */
public class MoneyClassAPI {
    public String name;
    public Config config;
    public MoneyClassAPI(String name){
        this.name = name;
        this.config = new Config(new File("plugins/RsMoney",name+".json").getAbsoluteFile());
    }
    public MoneyClassAPI(Player player){
        name = player.getName();
        this.config = new Config(new File("plugins/RsMoney",name+".json").getAbsoluteFile());
    }

    public void setPoint(float point){
        config.set("Point", point);
    }
    public float getPoint(){
        return (float)config.getDouble("Point");
    }
    public void setMoney(float money){
        config.set("Money", money);
    }
    public float getMoney(){
        return (float)config.getDouble("Money");
    }
}
