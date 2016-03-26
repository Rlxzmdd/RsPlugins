package Rs.Plugin.Money.Listeners;


import Rs.Plugin.Money.MoneyMainClass;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public class MoneyListenerAPI implements Listener{
    public MoneyMainClass plugin;
    public MoneyListenerAPI(MoneyMainClass plugin){
        this.plugin = plugin;
    }
    public MoneyMainClass getPlugin(){
        return plugin;
    }
}
