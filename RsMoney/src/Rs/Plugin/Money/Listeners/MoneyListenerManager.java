package Rs.Plugin.Money.Listeners;


import Rs.Plugin.Money.Listeners.Player.ListenerJoin;
import Rs.Plugin.Money.MoneyMainClass;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public class MoneyListenerManager {
    public MoneyMainClass plugin;
    public MoneyListenerManager(MoneyMainClass plugin){
        this.plugin = plugin;
        plugin.getLogger().notice("Register Listener");
       plugin.getServer().getPluginManager().registerEvents(new ListenerJoin(plugin),plugin);
        plugin.getLogger().notice("Register Done");
    }
    public Plugin getPlugin(){
        return plugin;
    }
}
