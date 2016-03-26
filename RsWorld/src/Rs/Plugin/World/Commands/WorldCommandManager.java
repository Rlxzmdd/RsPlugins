package Rs.Plugin.World.Commands;

import Rs.Plugin.World.Commands.Commands.proworld;
import Rs.Plugin.World.WorldMainClass;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public class WorldCommandManager {
    public WorldMainClass plugin;
    public WorldCommandManager(WorldMainClass plugin){
        this.plugin = plugin;
        plugin.getLogger().notice("Register Command");
        plugin.getServer().getCommandMap().register("proworld",new proworld("proworld",plugin));
        plugin.getLogger().notice("Register Done");
    }
    public Plugin getPlugin(){
        return plugin;
    }
}