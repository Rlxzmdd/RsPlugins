package Rs.Plugin.Money.Commands;

import Rs.Plugin.Money.Commands.Commands.MyMoney;
import Rs.Plugin.Money.Commands.Commands.Pay;
import Rs.Plugin.Money.MoneyMainClass;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public class MoneyCommandManager {
    public MoneyMainClass plugin;
    public MoneyCommandManager(MoneyMainClass plugin){
        this.plugin = plugin;
        plugin.getLogger().notice("Register Command");
        plugin.getServer().getCommandMap().register("pay",new Pay("pay",plugin));
        plugin.getServer().getCommandMap().register("mymoney",new MyMoney("mymoney",plugin));
        plugin.getLogger().notice("Register Done");
    }
    public Plugin getPlugin(){
        return plugin;
    }
}