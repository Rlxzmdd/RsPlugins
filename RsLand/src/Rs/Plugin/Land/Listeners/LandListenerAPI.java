package Rs.Plugin.Land.Listeners;


import cn.nukkit.event.Listener;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public class LandListenerAPI implements Listener{
    public Plugin plugin;
    public LandListenerAPI(Plugin plugin){
        this.plugin = plugin;
    }
    public Plugin getPlugin(){
        return plugin;
    }
}
