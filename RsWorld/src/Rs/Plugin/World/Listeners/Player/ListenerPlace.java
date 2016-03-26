package Rs.Plugin.World.Listeners.Player;

import Rs.Plugin.World.Listeners.WorldListenerAPI;
import Rs.Plugin.World.WorldMainClass;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.utils.TextFormat;

/**
 * Created by Rlx on 2016/2/15.
 */
public class ListenerPlace extends WorldListenerAPI {
    public ListenerPlace(WorldMainClass plugin) {
        super(plugin);
    }
    @EventHandler
    public void onMove(BlockPlaceEvent e){
        if(!getPlugin().getWorldUtils(e.getPlayer().getLevel().getName()).getObject().getTrustPlayers().canPlace(e.getPlayer().getName())){
            e.getPlayer().sendTip(plugin.getRun().getMsg("Can't",e.getPlayer()));
            e.setCancelled();
        }
    }
}
