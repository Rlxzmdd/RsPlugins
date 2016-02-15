package Rs.Plugin.Function.Event.Player;

/**
 * Created by Rlx on 2016/2/15.
 */

import Rs.Plugin.Function.Event.EventAPI;
import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.plugin.Plugin;


public class PlayerBreakSignEvent extends EventAPI
{
    protected Block sign;
    protected Player player;

    public PlayerBreakSignEvent(Plugin plugin, Player player, Block sign)
    {
        super(plugin);
        this.player = player;
        this.sign = sign;
    }

    public Block getBlock(){
        return this.sign;
    }

    public Player getPlayer(){
        return this.player;
    }
}
