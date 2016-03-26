package Rs.Plugin.World.Listeners.Player;

import Rs.Plugin.World.Listeners.WorldListenerAPI;
import Rs.Plugin.World.WorldMainClass;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.player.PlayerRespawnEvent;
import cn.nukkit.utils.TextFormat;

/**
 * Created by Rlx on 2016/2/15.
 */
public class ListenerTp extends WorldListenerAPI {
    public ListenerTp(WorldMainClass plugin) {
        super(plugin);
    }
    @EventHandler
    public void onSpawn(PlayerRespawnEvent e){
        if(!getPlugin().getWorldUtils(e.getPlayer().getLevel().getName()).getObject().getTrustPlayers().canTp(e.getPlayer().getName())){
            e.getPlayer().sendTip(plugin.getRun().getMsg("Can't", e.getPlayer()));
            e.setCancelled();
        }
    }
}
