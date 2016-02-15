package Rs.Plugin.Function.Event.Player;

/**
 * Created by Rlx on 2016/2/15.
 */

import Rs.Plugin.Function.Event.EventAPI;
import cn.nukkit.Player;
import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.plugin.Plugin;


public class PlayerPlaceSignEvent extends EventAPI
{
    protected BlockEntitySign sign;
    protected Player player;

    public PlayerPlaceSignEvent(Plugin plugin, Player player, BlockEntitySign sign)
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
