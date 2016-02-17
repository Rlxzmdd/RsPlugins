package Rs.Plugin.Function.Event.Player;

/**
 * Created by Rlx on 2016/2/15.
 */

import Rs.Plugin.Function.Event.EventAPI;
import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.event.HandlerList;
import cn.nukkit.plugin.Plugin;


public class PlayerTouchSignEvent extends EventAPI
{
    protected BlockEntitySign sign;
    protected Player player;
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }
    public PlayerTouchSignEvent(Plugin plugin, Player player, BlockEntitySign sign)
    {
        super(plugin);
        this.player = player;
        this.sign = sign;
    }

    public BlockEntitySign getSign(){
        return this.sign;
    }

    public Player getPlayer(){
        return this.player;
    }
}
