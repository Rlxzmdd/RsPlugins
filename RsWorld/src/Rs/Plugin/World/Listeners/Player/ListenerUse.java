package Rs.Plugin.World.Listeners.Player;

import Rs.Plugin.World.Listeners.WorldListenerAPI;
import Rs.Plugin.World.WorldMainClass;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.utils.TextFormat;

/**
 * Created by Rlx on 2016/2/15.
 */
public class ListenerUse extends WorldListenerAPI {
    public ListenerUse(WorldMainClass plugin) {
        super(plugin);
    }
    @EventHandler
    public void onIntere(PlayerInteractEvent e){
        if(e.getBlock().getId() == 54){
            if(!getPlugin().getWorldUtils(e.getPlayer().getLevel().getName()).getObject().getTrustPlayers().canChest(e.getPlayer().getName())){
                e.getPlayer().sendTip(plugin.getRun().getMsg("Can't", e.getPlayer()));
                e.setCancelled();
            }
        }else if(e.getBlock().getId() == 68){
            if(!getPlugin().getWorldUtils(e.getPlayer().getLevel().getName()).getObject().getTrustPlayers().canSign(e.getPlayer().getName())){
                e.getPlayer().sendTip(plugin.getRun().getMsg("Can't", e.getPlayer()));
                e.setCancelled();
            }
        }
        if(!getPlugin().getWorldUtils(e.getPlayer().getLevel().getName()).getObject().getTrustPlayers().canUse(e.getPlayer().getName())){
            e.getPlayer().sendTip(plugin.getRun().getMsg("Can't",e.getPlayer()));
            e.setCancelled();
        }
    }
}
