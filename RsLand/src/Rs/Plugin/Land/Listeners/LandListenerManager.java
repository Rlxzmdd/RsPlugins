package Rs.Plugin.Land.Listeners;

import Rs.Plugin.Land.Listeners.Player.ListenerMove;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public class LandListenerManager {
    public Plugin plugin;
    public LandListenerManager(Plugin plugin){
        this.plugin = plugin;
        plugin.getLogger().notice("Register Listener");
       plugin.getServer().getPluginManager().registerEvents(new ListenerMove(plugin),plugin);
        plugin.getLogger().notice("Register Done");
    }
    public Plugin getPlugin(){
        return plugin;
    }
}
