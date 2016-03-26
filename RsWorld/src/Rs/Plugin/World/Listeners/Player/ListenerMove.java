package Rs.Plugin.World.Listeners.Player;

import Rs.Plugin.World.Listeners.WorldListenerAPI;
import Rs.Plugin.World.WorldMainClass;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.utils.TextFormat;

/**
 * Created by Rlx on 2016/2/15.
 */
public class ListenerMove extends WorldListenerAPI {
    public ListenerMove(WorldMainClass plugin) {
        super(plugin);
    }
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if (!plugin.getWorldUtils(
                e.getPlayer().getLevel().getFolderName()
        ).
                getObject().getTrustPlayers().canMove(
                e.getPlayer().getName()
        )
                ){
            e.getPlayer().sendTip(plugin.getRun().getMsg("Can't", e.getPlayer()));
            e.setCancelled();
        }
    }
}
