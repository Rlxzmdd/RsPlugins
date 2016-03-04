package Rs.Plugin.Auto.Event.Player;

import Rs.Plugin.Function.Event.EventAPI;
import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.plugin.PluginEvent;
import cn.nukkit.plugin.Plugin;

/**
 * Created by admin on 2016/3/2.
 */
public class PlayerDoneLoginEvent extends EventAPI {
    private static final HandlerList handlers = new HandlerList();
    private Player player;

    public static HandlerList getHandlers() {
        return handlers;
    }
    public PlayerDoneLoginEvent(Plugin plugin, Player player)
    {
        super(plugin);
        this.player = player;
    }
    public Player getPlayer(){
        return player;
    }
}
