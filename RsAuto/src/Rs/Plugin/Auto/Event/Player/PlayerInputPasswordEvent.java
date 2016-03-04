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
public class PlayerInputPasswordEvent extends EventAPI {
    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private String password;

    public static HandlerList getHandlers() {
        return handlers;
    }
    public PlayerInputPasswordEvent(Plugin plugin, Player player,String password)
    {
        super(plugin);
        this.player = player;
        this.password = password;
    }
    public Player getPlayer(){
        return player;
    }
    public String getPassword(){
        return password;
    }
}

