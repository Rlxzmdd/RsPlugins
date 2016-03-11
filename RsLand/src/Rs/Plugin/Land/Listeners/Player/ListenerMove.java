package Rs.Plugin.Land.Listeners.Player;

import Rs.Plugin.Land.Listeners.LandListenerAPI;
import Rs.Plugin.Land.Listeners.LandListenerManager;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.plugin.Plugin;

/**
 * Created by Rlx on 2016/2/15.
 */
public class ListenerMove extends LandListenerAPI{
    public ListenerMove(Plugin plugin) {
        super(plugin);
    }
    @EventHandler
    public void onMove(PlayerMoveEvent e){

    }
}
