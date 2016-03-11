package Rs.Plugin.Land.Commands;

import Rs.Plugin.Land.Commands.Commands.Land;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public class LandCommandManager {
    public Plugin plugin;
    public LandCommandManager(Plugin plugin){
        this.plugin = plugin;
        plugin.getLogger().notice("Register Command");
        plugin.getServer().getCommandMap().register("233",new Land("233",plugin));
        plugin.getLogger().notice("Register Done");
    }
    public Plugin getPlugin(){
        return plugin;
    }
}