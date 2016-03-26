package Rs.Plugin.World.Listeners;

import Rs.Plugin.World.Listeners.Player.*;
import Rs.Plugin.World.WorldMainClass;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public class WorldListenerManager {
    public WorldMainClass plugin;
    public WorldListenerManager(WorldMainClass plugin){
        this.plugin = plugin;
        plugin.getLogger().notice("Register Listener");
       plugin.getServer().getPluginManager().registerEvents(new ListenerMove(plugin),plugin);
        plugin.getServer().getPluginManager().registerEvents(new ListenerPlace(plugin),plugin);
        plugin.getServer().getPluginManager().registerEvents(new ListenerBreak(plugin),plugin);
        plugin.getServer().getPluginManager().registerEvents(new ListenerTp(plugin),plugin);
        plugin.getServer().getPluginManager().registerEvents(new ListenerUse(plugin),plugin);
        plugin.getLogger().notice("Register Done");
    }
    public Plugin getPlugin(){
        return plugin;
    }
}
