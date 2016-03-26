package Rs.Plugin.World.Listeners;


import Rs.Plugin.World.Object.World;
import Rs.Plugin.World.WorldMainClass;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public class WorldListenerAPI implements Listener{
    public WorldMainClass plugin;
    public WorldListenerAPI(WorldMainClass plugin){
        this.plugin = plugin;
    }
    public WorldMainClass getPlugin(){
        return plugin;
    }
}
