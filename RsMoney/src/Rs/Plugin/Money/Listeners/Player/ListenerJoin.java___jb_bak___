package Rs.Plugin.Money.Listeners.Player;

import Rs.Plugin.Money.Listeners.MoneyListenerAPI;
import Rs.Plugin.Money.MoneyMainClass;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.Config;

import java.io.File;

/**
 * Created by Rlx on 2016/2/15.
 */
public class ListenerJoin extends MoneyListenerAPI {
    public ListenerJoin(MoneyMainClass plugin) {
        super(plugin);
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        getPlugin().getMoneyClass(e.getPlayer()).getMoneyConfig().newConfig();
    }
}
