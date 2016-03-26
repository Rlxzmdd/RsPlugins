package Rs.Plugin.Money;

import Rs.Plugin.Function.LangSend;
import Rs.Plugin.Money.Commands.MoneyCommandManager;
import Rs.Plugin.Money.Listeners.MoneyListenerManager;
import Rs.Plugin.Money.Utils.MoneyUtils;
import cn.nukkit.Player;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Library;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MoneyMainClass extends PluginBase{
    public File file = new File("plugins/RsMoney/").getAbsoluteFile();
    public static MoneyMainClass asd;
    public LinkedHashMap<String, Map<String,Float>> MoneyConfig = new LinkedHashMap<>();
    public Map<String,Map<String,Object>> CoinAndNumber = new HashMap<>();
    public void onEnable() {
         new MoneyListenerManager(this);
         new MoneyCommandManager(this);
        if(new File("/Players").getAbsoluteFile().exists()){
            getLogger().error("Have old File --- \"Players\"");
        }
        this.saveResource("Players.json");
        this.saveResource("config.yml");
        this.saveResource("en.json");
        this.saveResource("zh.json");
        Map<String,Object> config = new Config(file+"/Players.json").getAll();
        for(Iterator player = config.keySet().iterator();player.hasNext();){
            String zxc = player.next().toString();
            Map<String,Float> asd = (Map<String,Float>)config.get(zxc);
            MoneyConfig.put(zxc,asd);
        }
        config = new Config(file+"/config.yml").getAll();
        CoinAndNumber.put("Coin", (Map<String, Object>) config.get("Money|Coin"));
        CoinAndNumber.put("Number", (Map<String, Object>) config.get("Money|Number"));
        //getLogger().info("4asd");
        this.asd = this;
    }
    public void onDisable(){
        //getLogger().info(AllWorld+"rel");
        Config config = new Config(file+"/Players.json");
        config.setAll((LinkedHashMap)MoneyConfig);
        config.save();
}

    public static LangSend getRun(){
        return new LangSend(new Rs.Plugin.Money.Utils.MoneyLang());
    }

    public LinkedHashMap<String, Map<String,Float>> getMoneyConfig(){
        return this.MoneyConfig;
    }

    public void setPlayerConfig(LinkedHashMap<String, Map<String,Float>> all){
        this.getMoneyConfig().putAll(all);
    }

    public Map<String, Map<String,Object>> getCoinAndMoney(){
        return CoinAndNumber;
    }

    public MoneyUtils getUtils(){
        return new MoneyUtils(this);
    }

    public static MoneyClass getMoneyClass(Player player){
        return new MoneyClass(player);
    }
    public static MoneyClass getMoneyClass(String name){
        return new MoneyClass(name);
    }

}